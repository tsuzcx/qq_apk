package midas.x;

import com.pay.api.request.APBaseRequest;

public class d
{
  public static boolean a()
  {
    String str1 = p4.p().e().b.sessionId;
    String str2 = p4.p().e().b.sessionType;
    return (str1.equals("hy_gameid")) && (str2.startsWith("st_")) && (!str2.equals("st_dummy"));
  }
  
  public static boolean b()
  {
    String str1 = p4.p().e().b.sessionId;
    String str2 = p4.p().e().b.sessionType;
    return (str1.equals("hy_gameid")) && (str2.equals("st_dummy"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d
 * JD-Core Version:    0.7.0.1
 */