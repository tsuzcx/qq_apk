package midas.x;

import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class la
{
  public static byte[] a = "1234567890123456".getBytes();
  
  public static String a()
  {
    String str = UUID.randomUUID().toString();
    Object localObject = str;
    if (str.length() < 32) {
      for (;;)
      {
        localObject = str;
        if (str.length() >= 32) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(UUID.randomUUID().toString());
        str = ((StringBuilder)localObject).toString();
      }
    }
    int i = ((String)localObject).length();
    return ((String)localObject).substring(0, ((String)localObject).length() - i % 16);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, paramString2, new IvParameterSpec(a));
      paramString1 = pa.a(localCipher.doFinal(paramString1.getBytes()));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.la
 * JD-Core Version:    0.7.0.1
 */