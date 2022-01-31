package com.tencent.d.f;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e
{
  public static byte[] afK(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = (byte)"0123456789ABCDEF".indexOf(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static byte[] bQ(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static final String bytesToHexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.f.e
 * JD-Core Version:    0.7.0.1
 */