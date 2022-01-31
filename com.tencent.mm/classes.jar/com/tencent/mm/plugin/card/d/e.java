package com.tencent.mm.plugin.card.d;

import android.util.Base64;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class e
{
  private static String ae(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append("0123456789ABCDEF".charAt(paramArrayOfByte[i] >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static byte[] af(byte[] paramArrayOfByte)
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    return localKeyGenerator.generateKey().getEncoded();
  }
  
  public static String cA(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return null;
    }
    long l = System.currentTimeMillis() / 1000L;
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append("&");
    localStringBuilder2.append(l);
    localStringBuilder2.append("&");
    localStringBuilder2.append(paramString2);
    try
    {
      paramString2 = cB(localStringBuilder2.toString(), paramString2);
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append("&");
      localStringBuilder1.append(l);
      localStringBuilder1.append("&");
      localStringBuilder1.append(paramString2);
      return localStringBuilder1.toString();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
      }
    }
  }
  
  private static String cB(String paramString1, String paramString2)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA256"));
      paramString1 = Base64.encodeToString(localMac.doFinal(paramString1.getBytes()), 2);
      y.i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
    }
    return "";
  }
  
  public static String cy(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return null;
    }
    g.DN();
    int i = a.CK();
    paramString1 = "CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + i + "_" + paramString1;
    try
    {
      Object localObject = af(paramString1.getBytes());
      paramString1 = yI(paramString2);
      paramString2 = new SecretKeySpec((byte[])localObject, "AES");
      localObject = Cipher.getInstance("AES");
      ((Cipher)localObject).init(2, paramString2);
      paramString1 = new String(((Cipher)localObject).doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
    }
    return null;
  }
  
  public static String cz(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return null;
    }
    g.DN();
    int i = a.CK();
    paramString1 = "CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + i + "_" + paramString1;
    try
    {
      Object localObject = af(paramString1.getBytes());
      paramString1 = paramString2.getBytes();
      paramString2 = new SecretKeySpec((byte[])localObject, "AES");
      localObject = Cipher.getInstance("AES");
      ((Cipher)localObject).init(1, paramString2);
      paramString1 = ae(((Cipher)localObject).doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
    }
    return null;
  }
  
  private static byte[] yI(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.e
 * JD-Core Version:    0.7.0.1
 */