package com.tencent.mapsdk.internal;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class km
{
  private static final String a = "AESCrypt";
  private static final String b = "AES/CBC/PKCS7Padding";
  private static final String c = "UTF-8";
  private static final String d = "SHA-256";
  private static final byte[] e = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(224357);
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    paramString = paramString.getBytes("UTF-8");
    localMessageDigest.update(paramString, 0, paramString.length);
    paramString = Base64.encodeToString(localMessageDigest.digest(), 2);
    AppMethodBeat.o(224357);
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224371);
    try
    {
      paramString1 = new SecretKeySpec(Base64.decode(paramString1, 2), "AES");
      byte[] arrayOfByte = e;
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      localCipher.init(1, paramString1, new IvParameterSpec(arrayOfByte));
      paramString1 = Base64.encodeToString(localCipher.doFinal(paramString2), 2);
      AppMethodBeat.o(224371);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1 = new GeneralSecurityException(paramString1);
      AppMethodBeat.o(224371);
      throw paramString1;
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224420);
    char[] arrayOfChar1 = new char[16];
    char[] tmp11_10 = arrayOfChar1;
    tmp11_10[0] = 48;
    char[] tmp16_11 = tmp11_10;
    tmp16_11[1] = 49;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[2] = 50;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[3] = 51;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[4] = 52;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[5] = 53;
    char[] tmp41_36 = tmp36_31;
    tmp41_36[6] = 54;
    char[] tmp47_41 = tmp41_36;
    tmp47_41[7] = 55;
    char[] tmp53_47 = tmp47_41;
    tmp53_47[8] = 56;
    char[] tmp59_53 = tmp53_47;
    tmp59_53[9] = 57;
    char[] tmp65_59 = tmp59_53;
    tmp65_59[10] = 65;
    char[] tmp71_65 = tmp65_59;
    tmp71_65[11] = 66;
    char[] tmp77_71 = tmp71_65;
    tmp77_71[12] = 67;
    char[] tmp83_77 = tmp77_71;
    tmp83_77[13] = 68;
    char[] tmp89_83 = tmp83_77;
    tmp89_83[14] = 69;
    char[] tmp95_89 = tmp89_83;
    tmp95_89[15] = 70;
    tmp95_89;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar2);
    AppMethodBeat.o(224420);
    return paramArrayOfByte;
  }
  
  private static byte[] a(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(224384);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(1, paramSecretKeySpec, new IvParameterSpec(paramArrayOfByte1));
    paramSecretKeySpec = localCipher.doFinal(paramArrayOfByte2);
    AppMethodBeat.o(224384);
    return paramSecretKeySpec;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224395);
    try
    {
      paramString1 = new SecretKeySpec(Base64.decode(paramString1, 2), "AES");
      paramString2 = Base64.decode(paramString2, 2);
      byte[] arrayOfByte = e;
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      localCipher.init(2, paramString1, new IvParameterSpec(arrayOfByte));
      paramString1 = new String(localCipher.doFinal(paramString2), "UTF-8");
      AppMethodBeat.o(224395);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1 = new GeneralSecurityException(paramString1);
      AppMethodBeat.o(224395);
      throw paramString1;
    }
  }
  
  private static byte[] b(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(224406);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(2, paramSecretKeySpec, new IvParameterSpec(paramArrayOfByte1));
    paramSecretKeySpec = localCipher.doFinal(paramArrayOfByte2);
    AppMethodBeat.o(224406);
    return paramSecretKeySpec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.internal.km
 * JD-Core Version:    0.7.0.1
 */