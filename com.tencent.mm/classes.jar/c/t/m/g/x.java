package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class x
{
  private static volatile boolean a = true;
  private static String b = "";
  private static String c = "unknown";
  private static volatile int d = 0;
  private static volatile boolean e = false;
  private static volatile int f = -1;
  private static Map<String, x.a> g = new ConcurrentHashMap();
  private static BroadcastReceiver h = new y();
  private static String i = "";
  private static String j = "cmwap";
  private static String k = "3gwap";
  private static String l = "uniwap";
  private static String m = "ctwap";
  
  public static void a()
  {
    try
    {
      e();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      m.a().registerReceiver(h, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, x.a parama)
  {
    synchronized (g)
    {
      g.put(paramString, parama);
      return;
    }
  }
  
  public static String b()
  {
    return c;
  }
  
  public static String c()
  {
    switch (d)
    {
    default: 
      return "";
    case 1: 
      return "wifi";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    }
    return "4g";
  }
  
  public static String d()
  {
    switch (d)
    {
    default: 
      return "null";
    case 1: 
      return "wifi";
    }
    return b;
  }
  
  public static void e()
  {
    for (;;)
    {
      try
      {
        n = d;
      }
      finally {}
      try
      {
        ??? = ((ConnectivityManager)m.a().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((??? == null) || (!((NetworkInfo)???).isAvailable()) || (!((NetworkInfo)???).isConnected())) {
          break label588;
        }
        a = true;
        i1 = ((NetworkInfo)???).getType();
        if (i1 != 1) {
          break label189;
        }
        d = 1;
        f = 0;
        e = false;
        ??? = ((WifiManager)m.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        c = "ssid_" + ((WifiInfo)???).getSSID() + ((WifiInfo)???).getBSSID();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject4;
          boolean bool;
          if (n == d) {
            break label619;
          }
          synchronized (g)
          {
            localObject4 = g.values().iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while ((x.a)((Iterator)localObject4).next() == null);
            x.a.a(d, c);
          }
          if ((i1 != 13) && (i1 != 19)) {
            break;
          }
          d = 4;
        }
      }
      finally
      {
        for (;;)
        {
          if (n == d) {
            break label630;
          }
          synchronized (g)
          {
            Iterator localIterator2 = g.values().iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
            } while ((x.a)localIterator2.next() == null);
            x.a.a(d, c);
          }
          d = 3;
        }
        if (!b.contains(j)) {
          break label490;
        }
        i = "10.0.0.172";
        continue;
        if (!b.contains(l)) {
          break label510;
        }
        i = "10.0.0.172";
        continue;
        if (!b.contains(m)) {
          break label530;
        }
        i = "10.0.0.200";
        continue;
        i = "";
        continue;
        b = "unknown";
        d = 0;
        f = -1;
        c = "unknown";
        e = false;
        continue;
        b = "unknown";
        d = 0;
        f = -1;
        c = "unknown";
        e = false;
        continue;
        b = "unknown";
        d = 0;
        f = -1;
        c = "unknown";
        e = false;
        a = false;
        continue;
        for (;;)
        {
          return;
        }
      }
      if (n == d) {
        break label619;
      }
      synchronized (g)
      {
        Iterator localIterator1 = g.values().iterator();
        if (!localIterator1.hasNext()) {
          break label617;
        }
        if ((x.a)localIterator1.next() == null) {
          continue;
        }
        x.a.a(d, c);
      }
      label189:
      localObject4 = localObject2.getExtraInfo();
      if (localObject4 == null) {
        break label563;
      }
      b = ((String)localObject4).trim().toLowerCase();
      if (i1 != 0) {
        break label538;
      }
      c = "apn_" + b;
      i1 = localObject2.getSubtype();
      f = i1;
      if ((i1 != 1) && (i1 != 2) && (i1 != 4)) {
        break label372;
      }
      d = 2;
      bool = b.contains("wap");
      e = bool;
      if (bool)
      {
        if (!b.contains(k)) {
          break label470;
        }
        i = "10.0.0.172";
      }
    }
  }
  
  public static String f()
  {
    if (f == -1) {
      return "unknown";
    }
    switch (f)
    {
    default: 
      return "unknown";
    case 0: 
      return "wifi";
    case 13: 
      return "LTE";
    case 1: 
      return "GPRS";
    case 2: 
      return "EDGE";
    case 4: 
      return "CDMA";
    case 3: 
      return "UMTS";
    case 8: 
      return "HSDPA";
    case 9: 
      return "HSUPA";
    case 10: 
      return "HSPA";
    case 5: 
      return "EVDO_0";
    case 6: 
      return "EVDO_A";
    case 7: 
      return "1xRTT";
    case 11: 
      return "iDen";
    case 12: 
      return "EVDO_B";
    case 14: 
      return "EHRPD";
    }
    return "HSPAP";
  }
  
  public static int g()
  {
    return d;
  }
  
  public static boolean h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return e;
  }
  
  public static Integer j()
  {
    
    Object localObject2;
    Object localObject1;
    if ((d == 2) || (d == 3) || (d == 4))
    {
      n = 1;
      if (n == 0) {
        break label265;
      }
      localObject2 = m.a();
      localObject1 = b;
      localObject2 = (TelephonyManager)((Context)localObject2).getSystemService("phone");
      if ((localObject2 == null) || (((TelephonyManager)localObject2).getSimState() != 5)) {
        break label148;
      }
      localObject2 = ((TelephonyManager)localObject2).getSimOperator();
      if (((String)localObject2).length() <= 0) {
        break label148;
      }
      if ((!((String)localObject2).equals("46000")) && (!((String)localObject2).equals("46002"))) {
        break label112;
      }
      localObject1 = Integer.valueOf(1);
    }
    label97:
    for (int n = ((Integer)localObject1).intValue();; n = 0)
    {
      return Integer.valueOf(n);
      n = 0;
      break;
      label112:
      if (((String)localObject2).equals("46001"))
      {
        localObject1 = Integer.valueOf(2);
        break label97;
      }
      if (((String)localObject2).equals("46003"))
      {
        localObject1 = Integer.valueOf(3);
        break label97;
      }
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).toLowerCase();
        if ((((String)localObject1).contains("cmnet")) || (((String)localObject1).contains("cmwap")))
        {
          localObject1 = Integer.valueOf(1);
          break label97;
        }
        if ((((String)localObject1).contains("uninet")) || (((String)localObject1).contains("uniwap")) || (((String)localObject1).contains("3gnet")) || (((String)localObject1).contains("3gwap")))
        {
          localObject1 = Integer.valueOf(2);
          break label97;
        }
        if ((((String)localObject1).contains("ctnet")) || (((String)localObject1).contains("ctwap")))
        {
          localObject1 = Integer.valueOf(3);
          break label97;
        }
      }
      localObject1 = Integer.valueOf(0);
      break label97;
    }
  }
  
  public static Proxy k()
  {
    if ((e) && (!TextUtils.isEmpty(i))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(i, 80));
    }
    return null;
  }
  
  public static boolean l()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)m.a().getSystemService("power");
      if ((Build.VERSION.SDK_INT >= 23) && (localPowerManager != null))
      {
        boolean bool = ((Boolean)PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(localPowerManager, new Object[0])).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.x
 * JD-Core Version:    0.7.0.1
 */