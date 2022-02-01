package midas.x;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class ki
{
  public static String a;
  
  public static PublicKey a()
  {
    Object localObject = a;
    try
    {
      localObject = new X509EncodedKeySpec(kg.a((String)localObject));
      localObject = KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static byte[] a(String paramString, PublicKey paramPublicKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, paramPublicKey);
      paramString = localCipher.doFinal(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ki
 * JD-Core Version:    0.7.0.1
 */