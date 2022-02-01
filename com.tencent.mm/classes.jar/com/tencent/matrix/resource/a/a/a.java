package com.tencent.matrix.resource.a.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new StringBuilder();
        int j = paramArrayOfByte.length;
        i = 0;
        if (i < j)
        {
          int k = paramArrayOfByte[i];
          if ((k >= 0) && (k <= 15)) {
            ((StringBuilder)localObject).append('0').append(HEX_DIGITS[k]);
          } else {
            ((StringBuilder)localObject).append(HEX_DIGITS[(k >> 4 & 0xF)]).append(HEX_DIGITS[(k & 0xF)]);
          }
        }
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        throw new IllegalStateException(paramArrayOfByte);
      }
      paramArrayOfByte = ((StringBuilder)localObject).toString();
      return paramArrayOfByte;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.a.a.a
 * JD-Core Version:    0.7.0.1
 */