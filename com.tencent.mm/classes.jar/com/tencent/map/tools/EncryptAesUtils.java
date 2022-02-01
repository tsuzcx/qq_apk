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
    AppMethodBeat.i(236220);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramArrayOfByte = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(236220);
      throw paramArrayOfByte;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = EMPYT_BYTE_ARR;
      AppMethodBeat.o(236220);
      return paramArrayOfByte;
    }
    try
    {
      paramString = getCipher(paramString, paramAlgorithmParameterSpec, paramInt);
      if (paramString == null)
      {
        paramArrayOfByte = EMPYT_BYTE_ARR;
        AppMethodBeat.o(236220);
        return paramArrayOfByte;
      }
      paramArrayOfByte = paramString.doFinal(paramArrayOfByte);
      AppMethodBeat.o(236220);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte = EMPYT_BYTE_ARR;
      AppMethodBeat.o(236220);
    }
    return paramArrayOfByte;
  }
  
  private static String EnDeCryptBase64(String paramString1, String paramString2, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt)
  {
    AppMethodBeat.i(236217);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramString1 = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(236217);
      throw paramString1;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(236217);
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
          AppMethodBeat.o(236217);
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
            AppMethodBeat.o(236217);
            return paramString1;
          }
          if (paramInt == 2)
          {
            paramString1 = new String(paramString1);
            AppMethodBeat.o(236217);
            return paramString1;
          }
          AppMethodBeat.o(236217);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        AppMethodBeat.o(236217);
        return "";
      }
      paramString1 = null;
    }
  }
  
  public static byte[] decryptAes256(byte[] paramArrayOfByte, String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(236226);
    paramArrayOfByte = EnDeCrypt(paramArrayOfByte, paramString, paramAlgorithmParameterSpec, 2);
    AppMethodBeat.o(236226);
    return paramArrayOfByte;
  }
  
  public static String decryptAes256Base64(String paramString1, String paramString2, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(236222);
    paramString1 = EnDeCryptBase64(paramString1, paramString2, paramAlgorithmParameterSpec, 2);
    AppMethodBeat.o(236222);
    return paramString1;
  }
  
  public static byte[] encryptAes256(byte[] paramArrayOfByte, String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(236225);
    paramArrayOfByte = EnDeCrypt(paramArrayOfByte, paramString, paramAlgorithmParameterSpec, 1);
    AppMethodBeat.o(236225);
    return paramArrayOfByte;
  }
  
  public static String encryptAes256Base64(String paramString1, String paramString2, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    AppMethodBeat.i(236221);
    paramString1 = EnDeCryptBase64(paramString1, paramString2, paramAlgorithmParameterSpec, 1);
    AppMethodBeat.o(236221);
    return paramString1;
  }
  
  private static Cipher getCipher(String paramString, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt)
  {
    AppMethodBeat.i(236214);
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, paramString, paramAlgorithmParameterSpec);
    AppMethodBeat.o(236214);
    return localCipher;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.EncryptAesUtils
 * JD-Core Version:    0.7.0.1
 */