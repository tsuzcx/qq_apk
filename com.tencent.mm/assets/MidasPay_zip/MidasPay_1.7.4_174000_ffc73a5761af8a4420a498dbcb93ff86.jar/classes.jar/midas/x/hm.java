package midas.x;

import com.tencent.midas.comm.APLog;

public class hm
{
  public static String a(ew paramew, String paramString)
  {
    if ((paramew.m != null) && (paramew.m.length() > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramew.m.split("&");
        paramew = new StringBuilder();
        paramew.append("tetxtxt");
        i = 0;
        paramew.append(arrayOfString[0]);
        APLog.i("APPayChnageFriend", paramew.toString());
        paramString = new String();
        int j = arrayOfString.length;
        paramew = paramString;
        if (i < j)
        {
          if (!arrayOfString[i].contains("provide_uin=")) {
            break label137;
          }
          paramew = arrayOfString[i];
        }
        if (paramew.length() > 0)
        {
          paramew = paramew.split("=");
          if (paramew != null)
          {
            paramew = paramew[(paramew.length - 1)];
            return paramew;
          }
        }
      }
      catch (Exception paramew)
      {
        paramew.printStackTrace();
      }
      return "";
      label137:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hm
 * JD-Core Version:    0.7.0.1
 */