package com.tencent.liteav.basic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class a
{
  private static String a = "RSA";
  
  public static PrivateKey a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(229946);
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    paramArrayOfByte = KeyFactory.getInstance(a).generatePrivate(paramArrayOfByte);
    AppMethodBeat.o(229946);
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    AppMethodBeat.i(229939);
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPrivateKey);
    int j = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    if (j - i > 0)
    {
      if (j - i >= localCipher.getBlockSize()) {}
      for (paramPrivateKey = localCipher.doFinal(paramArrayOfByte, i, localCipher.getBlockSize());; paramPrivateKey = localCipher.doFinal(paramArrayOfByte, i, j - i))
      {
        localByteArrayOutputStream.write(paramPrivateKey);
        i = localCipher.getBlockSize() + i;
        break;
      }
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    AppMethodBeat.o(229939);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.d.a
 * JD-Core Version:    0.7.0.1
 */