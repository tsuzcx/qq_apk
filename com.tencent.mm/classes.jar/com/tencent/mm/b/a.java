package com.tencent.mm.b;

import android.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    paramString = Base64.decode(paramString.getBytes(), 0);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString, "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(Arrays.copyOf(paramString, paramString.length)));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.b.a
 * JD-Core Version:    0.7.0.1
 */