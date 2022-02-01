package com.tencent.map.tools.internal;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class q
{
  private static final byte[] a = new byte[0];
  
  public static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(180841);
    paramString1 = a(paramString1, paramString2, 1);
    AppMethodBeat.o(180841);
    return paramString1;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(180839);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramString1 = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(180839);
      throw paramString1;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(180839);
      return "";
    }
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramString1 = paramString1.getBytes();
        if ((paramString1 == null) || (paramString1.length == 0))
        {
          AppMethodBeat.o(180839);
          return "";
          if (paramInt == 2) {
            paramString1 = Base64.decode(paramString1.getBytes(), 2);
          }
        }
        else
        {
          paramString1 = a(paramString1, paramString2, paramInt);
          if (paramInt == 1)
          {
            paramString1 = Base64.encodeToString(paramString1, 2);
            AppMethodBeat.o(180839);
            return paramString1;
          }
          if (paramInt == 2)
          {
            paramString1 = new String(paramString1);
            AppMethodBeat.o(180839);
            return paramString1;
          }
          AppMethodBeat.o(180839);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        AppMethodBeat.o(180839);
        return "";
      }
      paramString1 = null;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(180843);
    paramArrayOfByte = a(paramArrayOfByte, paramString, 1);
    AppMethodBeat.o(180843);
    return paramArrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(180840);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramArrayOfByte = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(180840);
      throw paramArrayOfByte;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = a;
      AppMethodBeat.o(180840);
      return paramArrayOfByte;
    }
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(paramInt, paramString, new IvParameterSpec(u.G));
      if (localCipher == null)
      {
        paramArrayOfByte = a;
        AppMethodBeat.o(180840);
        return paramArrayOfByte;
      }
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      AppMethodBeat.o(180840);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte = a;
      AppMethodBeat.o(180840);
    }
    return paramArrayOfByte;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(180842);
    paramString1 = a(paramString1, paramString2, 2);
    AppMethodBeat.o(180842);
    return paramString1;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(180844);
    paramArrayOfByte = a(paramArrayOfByte, paramString, 2);
    AppMethodBeat.o(180844);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.q
 * JD-Core Version:    0.7.0.1
 */