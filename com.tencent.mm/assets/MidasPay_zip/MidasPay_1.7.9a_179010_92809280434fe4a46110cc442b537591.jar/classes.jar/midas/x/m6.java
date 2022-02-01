package midas.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Patterns;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m6
{
  static
  {
    Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
  }
  
  public static int a(Context paramContext)
  {
    boolean bool = APTools.c();
    j = -1;
    if (bool) {
      return -1;
    }
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      }
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        i = j;
        if (a((NetworkInfo)localObject)) {
          if (b((NetworkInfo)localObject))
          {
            i = 1000;
          }
          else
          {
            paramContext = (TelephonyManager)paramContext.getSystemService("phone");
            if (paramContext == null) {
              return -1;
            }
            i = paramContext.getNetworkType();
            switch (i)
            {
            default: 
              return -1;
            case 13: 
            case 18: 
              return 4;
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 14: 
            case 15: 
            case 17: 
              return 3;
            }
            return 2;
          }
        }
      }
      else
      {
        return 0;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i = j;
      }
    }
    APLog.i("networktype", String.valueOf(i));
    return i;
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected());
  }
  
  public static boolean a(String paramString)
  {
    return (b(paramString)) || (c(paramString));
  }
  
  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected()) && (paramNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"));
  }
  
  public static boolean b(String paramString)
  {
    return Patterns.IP_ADDRESS.matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = paramString.contains("::");
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::"))) {
      return false;
    }
    if (((paramString.startsWith(":")) && (!paramString.startsWith("::"))) || ((paramString.endsWith(":")) && (!paramString.endsWith("::")))) {
      return false;
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject = arrayOfString;
    if (bool)
    {
      localObject = new ArrayList(Arrays.asList(arrayOfString));
      if (paramString.endsWith("::")) {
        ((List)localObject).add("");
      } else if ((paramString.startsWith("::")) && (!((List)localObject).isEmpty())) {
        ((List)localObject).remove(0);
      }
      localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    }
    if (localObject.length > 8) {
      return false;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (k < localObject.length)
      {
        paramString = localObject[k];
        if (paramString.length() == 0)
        {
          int m = i + 1;
          i = m;
          if (m > 1) {
            return false;
          }
        }
        else
        {
          if ((k == localObject.length - 1) && (paramString.contains(".")))
          {
            if (!b(paramString)) {
              return false;
            }
            j += 2;
            i = 0;
            break label293;
          }
          if (paramString.length() > 4) {
            return false;
          }
        }
      }
      try
      {
        i = Integer.parseInt(paramString, 16);
        if (i >= 0)
        {
          if (i > 65535) {
            return false;
          }
          i = 0;
          j += 1;
          label293:
          k += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    if (j <= 8) {
      return (j >= 8) || (bool);
    }
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m6
 * JD-Core Version:    0.7.0.1
 */