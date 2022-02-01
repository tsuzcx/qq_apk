package midas.x;

import com.pay.api.request.APBaseRequest;

public class d
{
  public static boolean a()
  {
    String str1 = ed.b().n().a.sessionId;
    String str2 = ed.b().n().a.sessionType;
    return (str1.equals("hy_gameid")) && (str2.startsWith("st_")) && (!str2.equals("st_dummy"));
  }
  
  public static boolean b()
  {
    String str1 = ed.b().n().a.sessionId;
    String str2 = ed.b().n().a.sessionType;
    return (str1.equals("hy_gameid")) && (str2.equals("st_dummy"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.d
 * JD-Core Version:    0.7.0.1
 */