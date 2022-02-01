package com.qq.jce.wup;

import java.io.PrintStream;
import java.nio.ByteBuffer;

public class WupHexUtil
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final byte[] emptybytes = new byte[0];
  
  public static String byte2HexStr(byte paramByte)
  {
    int i = digits[(paramByte & 0xF)];
    paramByte = (byte)(paramByte >>> 4);
    return new String(new char[] { digits[(paramByte & 0xF)], i });
  }
  
  public static String bytes2HexStr(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.flip();
    byte[] arrayOfByte = new byte[paramByteBuffer.limit()];
    paramByteBuffer.get(arrayOfByte);
    return bytes2HexStr(arrayOfByte);
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
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
    byte b2 = 0;
    byte b1 = b2;
    if (paramString != null)
    {
      b1 = b2;
      if (paramString.length() == 1) {
        b1 = char2Byte(paramString.charAt(0));
      }
    }
    return b1;
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals("")))
    {
      localObject = emptybytes;
      return localObject;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= arrayOfByte.length) {
        break;
      }
      char c1 = paramString.charAt(i * 2);
      char c2 = paramString.charAt(i * 2 + 1);
      arrayOfByte[i] = ((byte)(char2Byte(c1) * 16 + char2Byte(c2)));
      i += 1;
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < 1000000)
    {
      paramArrayOfString = "234" + i;
      if (!new String(hexStr2Bytes(bytes2HexStr(paramArrayOfString.getBytes()))).equals(paramArrayOfString)) {
        System.out.println("error:" + paramArrayOfString);
      }
      i += 1;
    }
    System.out.println("use:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.qq.jce.wup.WupHexUtil
 * JD-Core Version:    0.7.0.1
 */