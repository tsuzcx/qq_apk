package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l
{
  private static final byte[] mAa = { 18, 52, 86, 120, -112, -85, -51, -17 };
  private static String mAb = null;
  
  public static String F(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(234887);
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
    for (localObject1 = localObject2;; localObject1 = dS(paramString2, paramString3))
    {
      AppMethodBeat.o(234887);
      return localObject1;
      if (!paramString1.equals("des")) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  public static String G(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(234888);
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
    for (localObject1 = localObject2;; localObject1 = dT(paramString2, paramString3))
    {
      AppMethodBeat.o(234888);
      return localObject1;
      if (!paramString1.equals("des")) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  public static String bKg()
  {
    try
    {
      AppMethodBeat.i(234891);
      if (mAb == null) {
        mAb = bKh();
      }
      String str = mAb;
      AppMethodBeat.o(234891);
      return str;
    }
    finally {}
  }
  
  private static String bKh()
  {
    AppMethodBeat.i(234892);
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
      AppMethodBeat.o(234892);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(234892);
    }
    return null;
  }
  
  private static String dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234889);
    if ((paramString1 == null) || (paramString1.length() < 8))
    {
      paramString1 = new Exception("secret key is not available");
      AppMethodBeat.o(234889);
      throw paramString1;
    }
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(234889);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      h.log(3, "SecretUtils", "start encode milles time = ".concat(String.valueOf(l)));
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString1, new IvParameterSpec(mAa));
      paramString1 = b.encode(localCipher.doFinal(paramString2.getBytes()));
      h.log(3, "SecretUtils", "end encode milles time = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(234889);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      h.log(6, "SecretUtils", "encode des error" + h.i(paramString1));
      AppMethodBeat.o(234889);
      throw paramString1;
    }
  }
  
  private static String dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234890);
    if ((paramString1 == null) || (paramString1.length() < 8))
    {
      paramString1 = new Exception("secret key is not available");
      AppMethodBeat.o(234890);
      throw paramString1;
    }
    paramString2 = b.decode(paramString2);
    if (paramString2.length == 0)
    {
      AppMethodBeat.o(234890);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      h.log(3, "SecretUtils", "start decode milles time = ".concat(String.valueOf(l)));
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString1, new IvParameterSpec(mAa));
      paramString1 = new String(localCipher.doFinal(paramString2));
      h.log(3, "SecretUtils", "end decode milles time = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(234890);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      h.log(6, "SecretUtils", "decode des error" + h.i(paramString1));
      AppMethodBeat.o(234890);
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.l
 * JD-Core Version:    0.7.0.1
 */