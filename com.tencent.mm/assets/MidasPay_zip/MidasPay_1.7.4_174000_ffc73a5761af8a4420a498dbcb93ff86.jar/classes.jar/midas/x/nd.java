package midas.x;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Patterns;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nd
{
  private static volatile long a = 0L;
  private static volatile String b = "";
  private static volatile Object c = new Object();
  private static volatile int d = -1;
  private static volatile long e = 0L;
  
  private static int a(Context paramContext)
  {
    try
    {
      localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      }
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        if (a((NetworkInfo)localObject))
        {
          if (b((NetworkInfo)localObject)) {
            return 1000;
          }
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext == null) {
            return -1;
          }
          int i = paramContext.getNetworkType();
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
      else {
        return 0;
      }
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNetWorkType() e = ");
      ((StringBuilder)localObject).append(paramContext.toString());
      mn.a("NetworkStatus", ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  private static int a(InetAddress paramInetAddress)
  {
    if ((paramInetAddress != null) && (!paramInetAddress.isLoopbackAddress()) && (!paramInetAddress.isLinkLocalAddress()) && (!paramInetAddress.isAnyLocalAddress()))
    {
      if ((paramInetAddress instanceof Inet6Address)) {
        return 2;
      }
      if ((paramInetAddress instanceof Inet4Address)) {
        return 1;
      }
    }
    return 0;
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    boolean bool1;
    if (l - a >= 10000L) {
      bool1 = true;
    } else {
      bool1 = paramBoolean;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      synchronized (c)
      {
        if (TextUtils.isEmpty(b)) {
          bool1 = true;
        }
        bool2 = bool1;
      }
    }
    if (!bool2) {
      return b;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("getNetworkIdentifier() finalRefresh=True : originRefresh=");
    ((StringBuilder)???).append(paramBoolean);
    ((StringBuilder)???).append(", networkIdentifier=");
    ((StringBuilder)???).append(b);
    ((StringBuilder)???).append(", ");
    ((StringBuilder)???).append(l);
    ((StringBuilder)???).append(" - ");
    ((StringBuilder)???).append(a);
    ((StringBuilder)???).append(" >= ");
    ((StringBuilder)???).append(10000L);
    ((StringBuilder)???).append("?");
    mn.a("NetworkStatus", ((StringBuilder)???).toString());
    a = l;
    int i = a(paramContext);
    if (i != 1000) {
      switch (i)
      {
      default: 
        b = "default_net";
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        b = c(paramContext);
        break;
      case 0: 
        b = "none_net";
        break;
      case -1: 
        b = "other_net";
        break;
      }
    } else {
      b = b(paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append(mg.a());
    paramContext.append("-");
    paramContext.append(b);
    b = paramContext.toString();
    return b;
  }
  
  public static void a()
  {
    synchronized (c)
    {
      b = "";
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected());
  }
  
  public static boolean a(String paramString)
  {
    return Patterns.IP_ADDRESS.matcher(paramString).matches();
  }
  
  public static int b(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    i = d;
    k = 1;
    boolean bool;
    if ((i >= 0) && (l - e < 10000L)) {
      bool = paramBoolean;
    } else {
      bool = true;
    }
    if (!bool) {
      return d;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getLocalIPvX() finalRefresh=True : originRefresh=");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", localIPvX=");
    ((StringBuilder)localObject1).append(d);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append(" - ");
    ((StringBuilder)localObject1).append(e);
    ((StringBuilder)localObject1).append(" >= ");
    ((StringBuilder)localObject1).append(10000L);
    ((StringBuilder)localObject1).append("?");
    mn.a("NetworkStatus", ((StringBuilder)localObject1).toString());
    e = l;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (Build.VERSION.SDK_INT < 21) {
        break label328;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getLinkProperties(paramContext.getActiveNetwork());
        break label264;
      }
      localObject1 = paramContext.getAllNetworks();
      j = localObject1.length;
      i = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int j;
        Object localObject2;
        NetworkInfo localNetworkInfo;
        label264:
        label328:
        label609:
        continue;
        label526:
        i += 1;
        continue;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
        i = -1;
        continue;
        paramContext = null;
      }
    }
    if (i < j)
    {
      localObject2 = localObject1[i];
      localNetworkInfo = paramContext.getNetworkInfo((Network)localObject2);
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        paramContext = paramContext.getLinkProperties((Network)localObject2);
        if (paramContext != null)
        {
          localObject1 = paramContext.getLinkAddresses().iterator();
          i = 0;
          j = i;
        }
        for (;;)
        {
          try
          {
            if (((Iterator)localObject1).hasNext())
            {
              paramContext = (LinkAddress)((Iterator)localObject1).next();
              if (paramContext == null) {
                break label743;
              }
              paramContext = paramContext.getAddress();
              j = a(paramContext);
              i |= j;
              break;
              localObject1 = paramContext.getActiveNetworkInfo();
              if (localObject1 == null) {
                break label748;
              }
              i = ((NetworkInfo)localObject1).getType();
              paramContext = ConnectivityManager.class.getDeclaredMethod("getLinkProperties", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(i) });
              localObject1 = paramContext.getClass().getDeclaredField("mLinkAddresses");
              ((Field)localObject1).setAccessible(true);
              paramContext = (ArrayList)((Field)localObject1).get(paramContext);
              if ((paramContext != null) && (paramContext.size() > 0))
              {
                localObject1 = Class.forName("android.net.LinkAddress").getDeclaredMethod("getAddress", new Class[0]);
                localObject2 = paramContext.iterator();
                i = 0;
              }
            }
          }
          catch (Throwable paramContext)
          {
            j = k;
            continue;
          }
          try
          {
            if (((Iterator)localObject2).hasNext())
            {
              paramContext = ((Iterator)localObject2).next();
              if (paramContext == null) {
                break label753;
              }
              paramContext = (InetAddress)((Method)localObject1).invoke(paramContext, new Object[0]);
              j = a(paramContext);
              i |= j;
            }
            else
            {
              j = i;
            }
          }
          catch (Throwable paramContext) {}
        }
        j = k;
        break label526;
        j = 0;
        k = 0;
        i = j;
        j = k;
        break label526;
        i = 0;
        j = k;
        if (j == 0)
        {
          mn.b("NetworkStatus", "getLocalIPvX() by 1.ConnectivityManager");
          if (d != i) {
            d = i;
          }
        }
        else
        {
          mn.b("NetworkStatus", "getLocalIPvX() by 2.NetworkInterface");
          j = i;
          do
          {
            do
            {
              try
              {
                paramContext = NetworkInterface.getNetworkInterfaces();
                k = i;
                if (paramContext != null)
                {
                  k = i;
                  j = i;
                  if (paramContext.hasMoreElements())
                  {
                    j = i;
                    localObject1 = (NetworkInterface)paramContext.nextElement();
                  }
                }
              }
              catch (SocketException paramContext)
              {
                for (;;)
                {
                  k = j;
                }
              }
              try
              {
                paramBoolean = ((NetworkInterface)localObject1).isUp();
              }
              catch (SocketException localSocketException)
              {
                break label609;
              }
              paramBoolean = false;
            } while (!paramBoolean);
            j = i;
            localObject1 = ((NetworkInterface)localObject1).getInetAddresses();
          } while (localObject1 == null);
          k = i;
          for (;;)
          {
            i = k;
            j = k;
            if (!((Enumeration)localObject1).hasMoreElements()) {
              break;
            }
            j = k;
            i = a((InetAddress)((Enumeration)localObject1).nextElement());
            k |= i;
          }
          if (d != k) {
            d = k;
          }
        }
        if (d < 0) {
          d = 0;
        }
        return d;
      }
    }
  }
  
  private static String b(Context paramContext)
  {
    Object localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject1 == null) {
      return "no_wifi_id";
    }
    localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
    if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 1))
    {
      Object localObject4 = (WifiManager)paramContext.getSystemService("wifi");
      if (localObject4 == null) {
        return "no_wifi_id";
      }
      Object localObject3 = null;
      localObject1 = localObject3;
      Object localObject2;
      try
      {
        if (nb.a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
          localObject1 = ((WifiManager)localObject4).getConnectionInfo();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject2 = localObject3;
      }
      if (localObject2 == null) {
        return "no_wifi_id";
      }
      localObject4 = ((WifiInfo)localObject2).getSSID();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        return "no_wifi_id";
      }
      localObject3 = localObject4;
      if ("<unknown ssid>".equals(localObject4))
      {
        localObject3 = localObject4;
        if ("02:00:00:00:00:00".equals(((WifiInfo)localObject2).getBSSID()))
        {
          int i = b(paramContext, false);
          if ((a(i)) && (b(i))) {
            paramContext = "ipv46-<unknown ssid>";
          }
          for (;;)
          {
            localObject2 = paramContext;
            break;
            if (b(i)) {
              paramContext = "ipv6-<unknown ssid>";
            } else if (a(i)) {
              paramContext = "ipv4-<unknown ssid>";
            } else {
              paramContext = "ipv0-<unknown ssid>";
            }
          }
          paramContext = new StringBuilder();
          paramContext.append("(android 8.1+) Need permissions : ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION. And (Android 9.0+) Need GPS on. Current sdk_int is ");
          paramContext.append(Build.VERSION.SDK_INT);
          paramContext.append(" !");
          mn.c("NetworkStatus", paramContext.toString());
          paramContext = new StringBuilder();
          paramContext.append("sdkInt=");
          paramContext.append(Build.VERSION.SDK_INT);
          localObject3 = paramContext.toString();
          paramContext = (Context)localObject3;
          if (Build.VERSION.SDK_INT >= 27)
          {
            paramContext = new StringBuilder();
            paramContext.append((String)localObject3);
            paramContext.append("&permission=");
            paramContext = paramContext.toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramContext);
            ((StringBuilder)localObject3).append(nc.a("android.permission.ACCESS_COARSE_LOCATION"));
            paramContext = ((StringBuilder)localObject3).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramContext);
            ((StringBuilder)localObject3).append("_");
            paramContext = ((StringBuilder)localObject3).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramContext);
            ((StringBuilder)localObject3).append(nc.a("android.permission.ACCESS_FINE_LOCATION"));
            paramContext = ((StringBuilder)localObject3).toString();
          }
          localObject3 = paramContext;
          if (Build.VERSION.SDK_INT >= 28)
          {
            localObject3 = (LocationManager)mg.a.getSystemService("location");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramContext);
            ((StringBuilder)localObject4).append("&gpson=");
            ((StringBuilder)localObject4).append(((LocationManager)localObject3).isProviderEnabled("gps"));
            localObject3 = ((StringBuilder)localObject4).toString();
          }
          paramContext = new StringBuilder();
          paramContext.append("ssid=");
          paramContext.append((String)localObject2);
          paramContext.append("&");
          paramContext.append((String)localObject3);
          mp.a("wifi.ssid", paramContext.toString());
          localObject3 = localObject2;
        }
      }
      return localObject3;
    }
    return "no_wifi_id";
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected()) && (paramNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"));
  }
  
  public static boolean b(String paramString)
  {
    return c(paramString);
  }
  
  private static String c(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "no_isp_code";
    }
    paramContext = paramContext.getSimOperator();
    StringBuilder localStringBuilder;
    if ((paramContext != null) && (paramContext.length() >= 5)) {
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      try
      {
        j = paramContext.length();
        i = j;
        if (j <= 6) {
          break label124;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        int i;
        paramContext.printStackTrace();
        return "no_isp_code";
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label129;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label129;
        }
      }
      paramContext = localStringBuilder.toString();
      return paramContext;
      return "no_isp_code";
      label124:
      int j = 0;
      continue;
      label129:
      j += 1;
    }
  }
  
  private static boolean c(String paramString)
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
            if (!a(paramString)) {
              return false;
            }
            j += 2;
            i = 0;
            break label305;
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
          label305:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nd
 * JD-Core Version:    0.7.0.1
 */