package midas.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.security.cert.CertificateNotYetValidException;
import javax.security.cert.CertificateExpiredException;

class li
{
  private static int a(Context paramContext)
  {
    try
    {
      if (f(paramContext))
      {
        if (e(paramContext)) {
          return 1000;
        }
        if (d(paramContext)) {
          return 4;
        }
        if (c(paramContext)) {
          return 3;
        }
        boolean bool = b(paramContext);
        if (bool) {
          return 1;
        }
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  static boolean a(Throwable paramThrowable)
  {
    String str = paramThrowable.toString();
    if (!(paramThrowable instanceof CertificateExpiredException))
    {
      if ((paramThrowable instanceof CertificateNotYetValidException)) {
        return true;
      }
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if ((str.contains("validation time")) && (str.contains("current time"))) {
        return true;
      }
      if ((str.contains("GMT")) && (str.contains("compared to"))) {
        return true;
      }
      if (str.contains("Could not validate certificate"))
      {
        long l = System.currentTimeMillis() / 1000L;
        if ((l > 0L) && (1451577600L > l)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  static boolean a(Throwable paramThrowable, Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramThrowable == null) {
      return false;
    }
    String str = Proxy.getDefaultHost();
    return (a(paramContext) == 1000) && (!TextUtils.isEmpty(str)) && (paramThrowable.toString().contains("Trust anchor for certification path not found"));
  }
  
  private static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && ("MOBILE".equals(paramContext.getTypeName())))
      {
        paramContext = Proxy.getDefaultHost();
        if (!TextUtils.isEmpty(paramContext)) {
          if (!paramContext.contains("wap"))
          {
            boolean bool = paramContext.contains("WAP");
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()) && ("MOBILE".equalsIgnoreCase(localNetworkInfo.getTypeName())))
      {
        int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
        if (i != 3)
        {
          if (i != 6)
          {
            switch (i)
            {
            default: 
              return false;
            case 10: 
              return true;
            case 9: 
              return true;
            }
            return true;
          }
          return true;
        }
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean d(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()) && ("MOBILE".equalsIgnoreCase(localNetworkInfo.getTypeName())))
      {
        int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
        return i == 13;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean e(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        boolean bool = "WIFI".equalsIgnoreCase(paramContext.getTypeName());
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean f(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.li
 * JD-Core Version:    0.7.0.1
 */