package midas.x;

import com.tencent.midas.comm.APLog;

public class q7
{
  public static String a(z4 paramz4, String paramString)
  {
    paramString = paramz4.m;
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramz4.m.split("&");
        paramz4 = new StringBuilder();
        paramz4.append("tetxtxt");
        i = 0;
        paramz4.append(arrayOfString[0]);
        APLog.i("APPayChnageFriend", paramz4.toString());
        paramString = new String();
        int j = arrayOfString.length;
        paramz4 = paramString;
        if (i < j)
        {
          if (!arrayOfString[i].contains("provide_uin=")) {
            break label136;
          }
          paramz4 = arrayOfString[i];
        }
        if (paramz4.length() > 0)
        {
          paramz4 = paramz4.split("=");
          if (paramz4 != null)
          {
            paramz4 = paramz4[(paramz4.length - 1)];
            return paramz4;
          }
        }
      }
      catch (Exception paramz4)
      {
        paramz4.printStackTrace();
      }
      return "";
      label136:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q7
 * JD-Core Version:    0.7.0.1
 */