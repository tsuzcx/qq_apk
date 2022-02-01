package c.t.m.g;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ak
{
  private Cipher a;
  private Cipher b;
  
  public ak(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      this.a = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.a.init(1, paramArrayOfByte);
      this.b = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.b.init(2, paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.a.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.ak
 * JD-Core Version:    0.7.0.1
 */