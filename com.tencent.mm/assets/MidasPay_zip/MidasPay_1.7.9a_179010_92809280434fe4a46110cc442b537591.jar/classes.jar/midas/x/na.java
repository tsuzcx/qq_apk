package midas.x;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class na
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes("UTF-8"), "HmacSHA256");
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(paramString2);
      paramString1 = pa.a(localMac.doFinal(paramString1.getBytes("UTF-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("hMacSha256() exception = ");
      paramString2.append(paramString1.toString());
      ca.a("HashTools", paramString2.toString());
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.na
 * JD-Core Version:    0.7.0.1
 */