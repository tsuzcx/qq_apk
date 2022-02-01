package midas.x;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class kh
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes("UTF-8"), "HmacSHA256");
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(paramString2);
      paramString1 = kj.a(localMac.doFinal(paramString1.getBytes("UTF-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("hMacSha256() exception = ");
      paramString2.append(paramString1.toString());
      jw.b("HashTools", paramString2.toString());
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kh
 * JD-Core Version:    0.7.0.1
 */