package com.tencent.upload.common;

public class StringUtils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final String sfEmptyString = "";
  
  public static String bytesToAscii(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {}
      try
      {
        return localStringBuilder.toString();
      }
      catch (Exception paramArrayOfByte) {}
      localStringBuilder.append((char)((paramArrayOfByte[i] + 256) % 256));
      i += 1;
    }
    return null;
  }
  
  public static String getEmptyString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean isIpv4String(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length == 4)) {
        try
        {
          int i = Integer.parseInt(paramString[0]);
          if ((i > 0) && (i <= 255))
          {
            i = Integer.parseInt(paramString[1]);
            if ((i >= 0) && (i <= 255))
            {
              i = Integer.parseInt(paramString[2]);
              if ((i >= 0) && (i <= 255))
              {
                i = Integer.parseInt(paramString[3]);
                if ((i >= 0) && (i <= 255)) {
                  return true;
                }
              }
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    }
    return false;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.common.StringUtils
 * JD-Core Version:    0.7.0.1
 */