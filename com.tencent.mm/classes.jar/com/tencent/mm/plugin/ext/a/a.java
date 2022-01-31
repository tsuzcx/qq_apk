package com.tencent.mm.plugin.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class a
{
  private static char[] fuo = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static SecretKey mdL = null;
  
  private static byte[] GB(String paramString)
  {
    AppMethodBeat.i(20296);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(20296);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    AppMethodBeat.o(20296);
    return arrayOfByte;
  }
  
  private static byte[] Nb(String paramString)
  {
    AppMethodBeat.i(20292);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(20292);
      return null;
    }
    bty();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, mdL);
    paramString = localCipher.doFinal(paramString.getBytes("UTF8"));
    AppMethodBeat.o(20292);
    return paramString;
  }
  
  public static long Nc(String paramString)
  {
    AppMethodBeat.i(20295);
    long l = Long.valueOf(decrypt(paramString).trim()).longValue();
    AppMethodBeat.o(20295);
    return l;
  }
  
  private static void bty()
  {
    AppMethodBeat.i(20291);
    try
    {
      if (mdL == null)
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(GB("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
        mdL = (SecretKey)localObjectInputStream.readObject();
        localObjectInputStream.close();
      }
      AppMethodBeat.o(20291);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AESUtil", localException, "", new Object[0]);
      AppMethodBeat.o(20291);
    }
  }
  
  private static String decrypt(String paramString)
  {
    AppMethodBeat.i(20294);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(20294);
      return null;
    }
    bty();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, mdL);
    paramString = new String(localCipher.doFinal(GB(paramString)), "UTF8");
    AppMethodBeat.o(20294);
    return paramString;
  }
  
  public static String jF(long paramLong)
  {
    AppMethodBeat.i(20293);
    Object localObject = Nb(String.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(20293);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(localObject.length * 2);
    int i = 0;
    while (i < localObject.length)
    {
      localStringBuilder.append(fuo[((localObject[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(fuo[(localObject[i] & 0xF)]);
      i += 1;
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(20293);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.a.a
 * JD-Core Version:    0.7.0.1
 */