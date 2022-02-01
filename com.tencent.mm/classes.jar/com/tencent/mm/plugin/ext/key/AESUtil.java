package com.tencent.mm.plugin.ext.key;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class AESUtil
{
  private static char[] hSd = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static SecretKey rkR = null;
  
  private static byte[] Xg(String paramString)
  {
    AppMethodBeat.i(24369);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(24369);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    AppMethodBeat.o(24369);
    return arrayOfByte;
  }
  
  private static String Xh(String paramString)
  {
    AppMethodBeat.i(24367);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(24367);
      return null;
    }
    ctG();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, rkR);
    paramString = new String(localCipher.doFinal(Xg(paramString)), "UTF8");
    AppMethodBeat.o(24367);
    return paramString;
  }
  
  private static byte[] agD(String paramString)
  {
    AppMethodBeat.i(24365);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(24365);
      return null;
    }
    ctG();
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, rkR);
    paramString = localCipher.doFinal(paramString.getBytes("UTF8"));
    AppMethodBeat.o(24365);
    return paramString;
  }
  
  public static long agE(String paramString)
  {
    AppMethodBeat.i(24368);
    long l = Long.valueOf(Xh(paramString).trim()).longValue();
    AppMethodBeat.o(24368);
    return l;
  }
  
  private static void ctG()
  {
    AppMethodBeat.i(24364);
    try
    {
      if (rkR == null)
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(Xg("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
        rkR = (SecretKey)localObjectInputStream.readObject();
        localObjectInputStream.close();
      }
      AppMethodBeat.o(24364);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AESUtil", localException, "", new Object[0]);
      AppMethodBeat.o(24364);
    }
  }
  
  public static String vy(long paramLong)
  {
    AppMethodBeat.i(24366);
    Object localObject = agD(String.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(24366);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(localObject.length * 2);
    int i = 0;
    while (i < localObject.length)
    {
      localStringBuilder.append(hSd[((localObject[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hSd[(localObject[i] & 0xF)]);
      i += 1;
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(24366);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.key.AESUtil
 * JD-Core Version:    0.7.0.1
 */