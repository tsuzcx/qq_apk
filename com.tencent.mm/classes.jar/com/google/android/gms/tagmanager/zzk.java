package com.google.android.gms.tagmanager;

public class zzk
{
  public static byte[] zzgR(String paramString)
  {
    int j = paramString.length();
    if (j % 2 != 0) {
      throw new IllegalArgumentException("purported base16 string has odd number of characters");
    }
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      int k = Character.digit(paramString.charAt(i), 16);
      int m = Character.digit(paramString.charAt(i + 1), 16);
      if ((k == -1) || (m == -1)) {
        throw new IllegalArgumentException("purported base16 string has illegal char");
      }
      arrayOfByte[(i / 2)] = ((byte)((k << 4) + m));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public static String zzq(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k & 0xF0) == 0) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(k & 0xFF));
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzk
 * JD-Core Version:    0.7.0.1
 */