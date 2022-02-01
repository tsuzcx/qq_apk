package midas.x;

import com.tencent.midas.comm.APLog;

public class hb
{
  public static String a(en paramen, String paramString)
  {
    if ((paramen.m != null) && (paramen.m.length() > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramen.m.split("&");
        paramen = new StringBuilder();
        paramen.append("tetxtxt");
        i = 0;
        paramen.append(arrayOfString[0]);
        APLog.i("APPayChnageFriend", paramen.toString());
        paramString = new String();
        int j = arrayOfString.length;
        paramen = paramString;
        if (i < j)
        {
          if (!arrayOfString[i].contains("provide_uin=")) {
            break label137;
          }
          paramen = arrayOfString[i];
        }
        if (paramen.length() > 0)
        {
          paramen = paramen.split("=");
          if (paramen != null)
          {
            paramen = paramen[(paramen.length - 1)];
            return paramen;
          }
        }
      }
      catch (Exception paramen)
      {
        paramen.printStackTrace();
      }
      return "";
      label137:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.hb
 * JD-Core Version:    0.7.0.1
 */