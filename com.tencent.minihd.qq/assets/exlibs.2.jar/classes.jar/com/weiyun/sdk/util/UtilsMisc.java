package com.weiyun.sdk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsMisc
{
  static final String HEXES = "0123456789ABCDEF";
  
  public static boolean IsDirNameValidate(String paramString)
  {
    return Pattern.compile("[^\\\\/:*?\"<>|.]+").matcher(paramString).matches();
  }
  
  public static boolean IsFileNameValidate(String paramString)
  {
    return Pattern.compile("[^\\\\/:*?\"<>|]+").matcher(paramString).matches();
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
  
  public static String byteArrayToHexString(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt * 2);
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfByte[i];
      localStringBuilder.append("0123456789ABCDEF".charAt((j & 0xF0) >> 4)).append("0123456789ABCDEF".charAt(j & 0xF));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static String getValidateFileName(String paramString)
  {
    if (Utils.isEmptyString(paramString)) {
      return "empty";
    }
    String str1 = paramString;
    try
    {
      if (!IsFileNameValidate(paramString)) {
        str1 = newValidateFileName(paramString);
      }
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = paramString;
      }
    }
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public static String hexStringToByteArrayFromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append("0123456789ABCDEF".charAt((k & 0xF0) >> 4)).append("0123456789ABCDEF".charAt(k & 0xF));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String newValidateFileName(String paramString)
  {
    return paramString.replaceAll("[\\\\/:*?\"<>|]+", "_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.UtilsMisc
 * JD-Core Version:    0.7.0.1
 */