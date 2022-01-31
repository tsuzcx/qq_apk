package c.t.m.g;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class cw
{
  private static final byte[] a = { 84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49 };
  private static final byte[] b = new byte[0];
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    return b(paramArrayOfByte, paramString);
  }
  
  private static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return b;
    }
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, paramString, new IvParameterSpec(a));
      if (localCipher == null) {
        return b;
      }
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.cw
 * JD-Core Version:    0.7.0.1
 */