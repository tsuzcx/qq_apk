package com.tencent.upload.common;

public class Convert
{
  public static byte[] decryptTea(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = new Tea().decrypt(arrayOfByte, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      UploadLog.w("Base.Convert", "TEA解密失败");
    }
    return null;
  }
  
  public static byte[] encryptTea(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = new Tea().encrypt(arrayOfByte, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      UploadLog.w("Base.Convert", "TEA加密失败");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.common.Convert
 * JD-Core Version:    0.7.0.1
 */