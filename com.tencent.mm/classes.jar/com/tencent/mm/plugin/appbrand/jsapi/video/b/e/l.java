package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l
{
  private static String ltA = null;
  private static final byte[] ltz = { 18, 52, 86, 120, -112, -85, -51, -17 };
  
  public static String D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(211218);
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
    for (localObject1 = localObject2;; localObject1 = dD(paramString2, paramString3))
    {
      AppMethodBeat.o(211218);
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
    AppMethodBeat.i(211219);
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
    for (localObject1 = localObject2;; localObject1 = dE(paramString2, paramString3))
    {
      AppMethodBeat.o(211219);
      return localObject1;
      if (!paramString1.equals("des")) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  public static String boD()
  {
    try
    {
      AppMethodBeat.i(211222);
      if (ltA == null) {
        ltA = boE();
      }
      String str = ltA;
      AppMethodBeat.o(211222);
      return str;
    }
    finally {}
  }
  
  private static String boE()
  {
    AppMethodBeat.i(211223);
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
      AppMethodBeat.o(211223);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(211223);
    }
    return null;
  }
  
  private static String dD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211220);
    if ((paramString1 == null) || (paramString1.length() < 8))
    {
      paramString1 = new Exception("secret key is not available");
      AppMethodBeat.o(211220);
      throw paramString1;
    }
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(211220);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      h.log(3, "SecretUtils", "start encode milles time = ".concat(String.valueOf(l)));
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString1, new IvParameterSpec(ltz));
      paramString1 = b.encode(localCipher.doFinal(paramString2.getBytes()));
      h.log(3, "SecretUtils", "end encode milles time = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(211220);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      h.log(6, "SecretUtils", "encode des error" + h.i(paramString1));
      AppMethodBeat.o(211220);
      throw paramString1;
    }
  }
  
  private static String dE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211221);
    if ((paramString1 == null) || (paramString1.length() < 8))
    {
      paramString1 = new Exception("secret key is not available");
      AppMethodBeat.o(211221);
      throw paramString1;
    }
    paramString2 = b.decode(paramString2);
    if (paramString2.length == 0)
    {
      AppMethodBeat.o(211221);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      h.log(3, "SecretUtils", "start decode milles time = ".concat(String.valueOf(l)));
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString1, new IvParameterSpec(ltz));
      paramString1 = new String(localCipher.doFinal(paramString2));
      h.log(3, "SecretUtils", "end decode milles time = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(211221);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      h.log(6, "SecretUtils", "decode des error" + h.i(paramString1));
      AppMethodBeat.o(211221);
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.l
 * JD-Core Version:    0.7.0.1
 */