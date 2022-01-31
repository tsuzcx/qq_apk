package com.tencent.mm.plugin.card.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class e
{
  private static byte[] Is(String paramString)
  {
    AppMethodBeat.i(88847);
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    AppMethodBeat.o(88847);
    return arrayOfByte;
  }
  
  private static String aw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88846);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88846);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append("0123456789ABCDEF".charAt(paramArrayOfByte[i] >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(88846);
    return paramArrayOfByte;
  }
  
  private static byte[] ax(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88848);
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    paramArrayOfByte = localKeyGenerator.generateKey().getEncoded();
    AppMethodBeat.o(88848);
    return paramArrayOfByte;
  }
  
  public static String dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88844);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      AppMethodBeat.o(88844);
      return null;
    }
    g.RJ();
    int i = a.getUin();
    paramString1 = "CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + i + "_" + paramString1;
    try
    {
      Object localObject = ax(paramString1.getBytes());
      paramString1 = Is(paramString2);
      paramString2 = new SecretKeySpec((byte[])localObject, "AES");
      localObject = Cipher.getInstance("AES");
      ((Cipher)localObject).init(2, paramString2);
      paramString1 = new String(((Cipher)localObject).doFinal(paramString1));
      AppMethodBeat.o(88844);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
        paramString1 = null;
      }
    }
  }
  
  public static String dw(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(88845);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      AppMethodBeat.o(88845);
      return null;
    }
    g.RJ();
    int i = a.getUin();
    paramString1 = "CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + i + "_" + paramString1;
    try
    {
      Object localObject2 = ax(paramString1.getBytes());
      paramString1 = paramString2.getBytes();
      paramString2 = new SecretKeySpec((byte[])localObject2, "AES");
      localObject2 = Cipher.getInstance("AES");
      ((Cipher)localObject2).init(1, paramString2);
      paramString1 = aw(((Cipher)localObject2).doFinal(paramString1));
      AppMethodBeat.o(88845);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
        paramString1 = localObject1;
      }
    }
  }
  
  public static String dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88849);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(88849);
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
      paramString2 = dy(localStringBuilder2.toString(), paramString2);
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append("&");
      localStringBuilder1.append(l);
      localStringBuilder1.append("&");
      localStringBuilder1.append(paramString2);
      paramString1 = localStringBuilder1.toString();
      AppMethodBeat.o(88849);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
      }
    }
  }
  
  private static String dy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88850);
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA256"));
      paramString1 = Base64.encodeToString(localMac.doFinal(paramString1.getBytes()), 2);
      ab.i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(88850);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
      AppMethodBeat.o(88850);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.e
 * JD-Core Version:    0.7.0.1
 */