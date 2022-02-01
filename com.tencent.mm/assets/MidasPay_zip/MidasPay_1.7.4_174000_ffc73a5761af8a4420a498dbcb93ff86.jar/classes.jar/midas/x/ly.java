package midas.x;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ly
{
  public static String a(String paramString1, String paramString2)
  {
    return c(paramString1, paramString2);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject = str;
      if (str.length() == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('0');
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuffer.append(((String)localObject).toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, paramString, new IvParameterSpec("1234567890123456".getBytes()));
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      ks.c("decryptAESTools", String.valueOf(paramArrayOfByte));
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte);
    }
    return "";
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString.length() < 1) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length() / 2)
    {
      int j = i * 2;
      int k = j + 1;
      arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(j, k), 16) * 16 + Integer.parseInt(paramString.substring(k, j + 2), 16)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return a(a(paramString1), paramString2);
  }
  
  public static String c(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, paramString2, new IvParameterSpec("1234567890123456".getBytes()));
      paramString2 = localCipher.doFinal(paramString1.getBytes());
    }
    catch (Exception paramString2)
    {
      ks.c("encryptAESTools", String.valueOf(paramString2));
      paramString2 = null;
    }
    if (paramString2 != null) {
      return a(paramString2);
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ly
 * JD-Core Version:    0.7.0.1
 */