package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l
{
  private static final byte[] lpc = { 18, 52, 86, 120, -112, -85, -51, -17 };
  private static String lpd = null;
  
  public static String D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(206191);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (!paramString1.isEmpty())
    {
      i = -1;
      switch (paramString1.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (localObject1 = localObject2;; localObject1 = dB(paramString2, paramString3))
    {
      AppMethodBeat.o(206191);
      return localObject1;
      if (!paramString1.equals("des")) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  public static String E(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(206192);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (!paramString1.isEmpty())
    {
      i = -1;
      switch (paramString1.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (localObject1 = localObject2;; localObject1 = dC(paramString2, paramString3))
    {
      AppMethodBeat.o(206192);
      return localObject1;
      if (!paramString1.equals("des")) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  public static String bnT()
  {
    try
    {
      AppMethodBeat.i(206195);
      if (lpd == null) {
        lpd = bnU();
      }
      String str = lpd;
      AppMethodBeat.o(206195);
      return str;
    }
    finally {}
  }
  
  private static String bnU()
  {
    AppMethodBeat.i(206196);
    try
    {
      Object localObject2 = SecureRandom.getInstance("SHA1PRNG");
      Object localObject1 = new byte[20];
      ((SecureRandom)localObject2).nextBytes((byte[])localObject1);
      localObject2 = new StringBuffer(40);
      int i = 0;
      while (i < 20)
      {
        int j = localObject1[i];
        ((StringBuffer)localObject2).append("0123456789ABCDEF".charAt(j >> 4 & 0xF)).append("0123456789ABCDEF".charAt(j & 0xF));
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject2).toString();
      AppMethodBeat.o(206196);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(206196);
    }
    return null;
  }
  
  private static String dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206193);
    if ((paramString1 == null) || (paramString1.length() < 8))
    {
      paramString1 = new Exception("secret key is not available");
      AppMethodBeat.o(206193);
      throw paramString1;
    }
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(206193);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      h.log(3, "SecretUtils", "start encode milles time = ".concat(String.valueOf(l)));
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString1, new IvParameterSpec(lpc));
      paramString1 = b.encode(localCipher.doFinal(paramString2.getBytes()));
      h.log(3, "SecretUtils", "end encode milles time = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(206193);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      h.log(6, "SecretUtils", "encode des error" + h.h(paramString1));
      AppMethodBeat.o(206193);
      throw paramString1;
    }
  }
  
  private static String dC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206194);
    if ((paramString1 == null) || (paramString1.length() < 8))
    {
      paramString1 = new Exception("secret key is not available");
      AppMethodBeat.o(206194);
      throw paramString1;
    }
    paramString2 = b.decode(paramString2);
    if (paramString2.length == 0)
    {
      AppMethodBeat.o(206194);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      h.log(3, "SecretUtils", "start decode milles time = ".concat(String.valueOf(l)));
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString1, new IvParameterSpec(lpc));
      paramString1 = new String(localCipher.doFinal(paramString2));
      h.log(3, "SecretUtils", "end decode milles time = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(206194);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      h.log(6, "SecretUtils", "decode des error" + h.h(paramString1));
      AppMethodBeat.o(206194);
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.l
 * JD-Core Version:    0.7.0.1
 */