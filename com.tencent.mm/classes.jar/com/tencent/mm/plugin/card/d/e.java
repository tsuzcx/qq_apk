package com.tencent.mm.plugin.card.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class e
{
  private static byte[] Vp(String paramString)
  {
    AppMethodBeat.i(113775);
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    AppMethodBeat.o(113775);
    return arrayOfByte;
  }
  
  private static String aK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113774);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(113774);
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
    AppMethodBeat.o(113774);
    return paramArrayOfByte;
  }
  
  private static byte[] aL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113776);
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    paramArrayOfByte = localKeyGenerator.generateKey().getEncoded();
    AppMethodBeat.o(113776);
    return paramArrayOfByte;
  }
  
  public static String eS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113772);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      AppMethodBeat.o(113772);
      return null;
    }
    g.agP();
    int i = a.getUin();
    paramString1 = "CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + i + "_" + paramString1;
    try
    {
      Object localObject = aL(paramString1.getBytes());
      paramString1 = Vp(paramString2);
      paramString2 = new SecretKeySpec((byte[])localObject, "AES");
      localObject = Cipher.getInstance("AES");
      ((Cipher)localObject).init(2, paramString2);
      paramString1 = new String(((Cipher)localObject).doFinal(paramString1));
      AppMethodBeat.o(113772);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
        paramString1 = null;
      }
    }
  }
  
  public static String eT(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(113773);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      AppMethodBeat.o(113773);
      return null;
    }
    g.agP();
    int i = a.getUin();
    paramString1 = "CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + i + "_" + paramString1;
    try
    {
      Object localObject2 = aL(paramString1.getBytes());
      paramString1 = paramString2.getBytes();
      paramString2 = new SecretKeySpec((byte[])localObject2, "AES");
      localObject2 = Cipher.getInstance("AES");
      ((Cipher)localObject2).init(1, paramString2);
      paramString1 = aK(((Cipher)localObject2).doFinal(paramString1));
      AppMethodBeat.o(113773);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
        paramString1 = localObject1;
      }
    }
  }
  
  public static String eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113777);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(113777);
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
      paramString2 = eV(localStringBuilder2.toString(), paramString2);
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append("&");
      localStringBuilder1.append(l);
      localStringBuilder1.append("&");
      localStringBuilder1.append(paramString2);
      paramString1 = localStringBuilder1.toString();
      AppMethodBeat.o(113777);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
      }
    }
  }
  
  private static String eV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113778);
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA256"));
      paramString1 = Base64.encodeToString(localMac.doFinal(paramString1.getBytes()), 2);
      ac.i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(113778);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", paramString1, "", new Object[0]);
      AppMethodBeat.o(113778);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.e
 * JD-Core Version:    0.7.0.1
 */