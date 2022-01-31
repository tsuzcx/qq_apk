package com.tencent.mm.plugin.ext.a;

import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class a
{
  private static char[] hRL = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static SecretKey jJH = null;
  
  private static byte[] Ca(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    aNv();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, jJH);
    return localCipher.doFinal(paramString.getBytes("UTF8"));
  }
  
  public static long Cb(String paramString)
  {
    return Long.valueOf(decrypt(paramString).trim()).longValue();
  }
  
  private static void aNv()
  {
    try
    {
      if (jJH == null)
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(xI("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
        jJH = (SecretKey)localObjectInputStream.readObject();
        localObjectInputStream.close();
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AESUtil", localException, "", new Object[0]);
    }
  }
  
  private static String decrypt(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    aNv();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, jJH);
    return new String(localCipher.doFinal(xI(paramString)), "UTF8");
  }
  
  public static String ei(long paramLong)
  {
    byte[] arrayOfByte = Ca(String.valueOf(paramLong));
    if (arrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(arrayOfByte.length * 2);
    int i = 0;
    while (i < arrayOfByte.length)
    {
      localStringBuilder.append(hRL[((arrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hRL[(arrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static byte[] xI(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.a.a
 * JD-Core Version:    0.7.0.1
 */