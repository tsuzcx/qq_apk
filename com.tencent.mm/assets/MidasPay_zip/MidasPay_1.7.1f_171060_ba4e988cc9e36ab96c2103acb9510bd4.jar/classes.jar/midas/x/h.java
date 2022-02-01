package midas.x;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class h
{
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = g.b(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label25:
      break label25;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.h
 * JD-Core Version:    0.7.0.1
 */