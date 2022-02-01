package com.tencent.map.tools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAesUtils
{
  private static final String CipherMode = "AES/CBC/PKCS5Padding";
  private static final String EMPTY_STRING = "";
  private static final byte[] EMPYT_BYTE_ARR = new byte[0];
  
  private static byte[] EnDeCrypt(byte[] paramArrayOfByte, String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt)
  {
    AppMethodBeat.i(210969);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramArrayOfByte = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(210969);
      throw paramArrayOfByte;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = EMPYT_BYTE_ARR;
      AppMethodBeat.o(210969);
      return paramArrayOfByte;
    }
    try
    {
      paramString = getCipher(paramString, paramAlgorithmParameterSpec, paramInt);
      if (paramString == null) {
        return paramArrayOfByte;
      }
      paramArrayOfByte = paramString.doFinal(paramArrayOfByte);
      AppMethodBeat.o(210969);
      return paramArrayOfByte;
    }
    finally
    {
      paramArrayOfByte = EMPYT_BYTE_ARR;
      AppMethodBeat.o(210969);
    }
    return paramArrayOfByte;
  }
  
  private static String EnDeCryptBase64(String paramString1, String paramString2, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt)
  {
    AppMethodBeat.i(210968);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramString1 = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(210968);
      throw paramString1;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(210968);
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
          AppMethodBeat.o(210968);
          return "";
          if (paramInt == 2) {
            paramString1 = Base64.decode(paramString1.getBytes(), 2);
          }
        }
        else
        {
          paramString1 = EnDeCrypt(paramString1, paramString2, paramAlgorithmParameterSpec, paramInt);
          if (paramInt == 1)
          {
            paramString1 = Base64.encodeToString(paramString1, 2);
            AppMethodBeat.o(210968);
            return paramString1;
          }
          if (paramInt == 2)
          {
            paramString1 = new String(paramString1);
            AppMethodBeat.o(210968);
            return paramString1;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(210968);
        return "";
      }
      paramString1 = null;
    }
  }
  
  public static byte[] decryptAes256(byte[] paramArrayOfByte, String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(210976);
    paramArrayOfByte = EnDeCrypt(paramArrayOfByte, paramString, paramAlgorithmParameterSpec, 2);
    AppMethodBeat.o(210976);
    return paramArrayOfByte;
  }
  
  public static String decryptAes256Base64(String paramString1, String paramString2, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(210973);
    paramString1 = EnDeCryptBase64(paramString1, paramString2, paramAlgorithmParameterSpec, 2);
    AppMethodBeat.o(210973);
    return paramString1;
  }
  
  public static byte[] encryptAes256(byte[] paramArrayOfByte, String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(210974);
    paramArrayOfByte = EnDeCrypt(paramArrayOfByte, paramString, paramAlgorithmParameterSpec, 1);
    AppMethodBeat.o(210974);
    return paramArrayOfByte;
  }
  
  public static String encryptAes256Base64(String paramString1, String paramString2, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(210971);
    paramString1 = EnDeCryptBase64(paramString1, paramString2, paramAlgorithmParameterSpec, 1);
    AppMethodBeat.o(210971);
    return paramString1;
  }
  
  private static Cipher getCipher(String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt)
  {
    AppMethodBeat.i(210966);
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, paramString, paramAlgorithmParameterSpec);
    AppMethodBeat.o(210966);
    return localCipher;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.EncryptAesUtils
 * JD-Core Version:    0.7.0.1
 */