package midas.x;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class oa
{
  public static String a;
  
  public static PublicKey a()
  {
    Object localObject = a;
    try
    {
      localObject = new X509EncodedKeySpec(ma.a((String)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.oa
 * JD-Core Version:    0.7.0.1
 */