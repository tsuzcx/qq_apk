package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;

public class aw
{
  public static String a;
  public static String b;
  public static volatile boolean c = false;
  private static final String d = aw.class.getSimpleName();
  private static String e = "cmwap";
  private static String f = "3gwap";
  private static String g = "uniwap";
  private static String h = "ctwap";
  private static Context i;
  private static volatile boolean j = true;
  private static String k;
  private static volatile int l;
  private static int m;
  private static String n = "";
  
  static
  {
    a = "";
    k = "";
    b = "";
    l = 0;
    m = 0;
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        switch (l)
        {
        case 1: 
          str = "unknown";
          return str;
        }
      }
      finally {}
      String str = "ssid_" + k + b;
      continue;
      str = "apn_" + a;
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      i = paramContext;
      b();
      f();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(HttpClient paramHttpClient)
  {
    if ((c) && (!TextUtils.isEmpty(n)))
    {
      HttpHost localHttpHost = new HttpHost(n, 80);
      paramHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
      ax.a(d, "setProxy... sProxyAddress:" + n + ",apn:" + a);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  /* Error */
  public static boolean a(Integer paramInteger)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokevirtual 140	java/lang/Integer:intValue	()I
    //   11: iconst_1
    //   12: if_icmpeq +25 -> 37
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: invokevirtual 140	java/lang/Integer:intValue	()I
    //   21: iconst_2
    //   22: if_icmpeq +15 -> 37
    //   25: aload_0
    //   26: invokevirtual 140	java/lang/Integer:intValue	()I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_3
    //   32: if_icmpne +10 -> 42
    //   35: iload_3
    //   36: istore_2
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -7 -> 37
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramInteger	Integer
    //   29	4	1	i1	int
    //   6	38	2	bool1	boolean
    //   1	35	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	47	finally
    //   17	30	47	finally
  }
  
  public static void b()
  {
    for (;;)
    {
      int i1;
      try
      {
        ax.b(d, "updateApn");
        localNetworkInfo = ((ConnectivityManager)i.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null) {
          continue;
        }
        a = "";
        l = 0;
        c = false;
        n = "";
        j = false;
      }
      catch (Exception localException)
      {
        NetworkInfo localNetworkInfo;
        localException.printStackTrace();
        continue;
      }
      finally {}
      return;
      Object localObject2;
      if ((localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        j = true;
        i1 = localNetworkInfo.getType();
        if (i1 == 1)
        {
          l = 1;
          c = false;
          n = "";
          localObject2 = ((WifiManager)i.getSystemService("wifi")).getConnectionInfo();
          k = ((WifiInfo)localObject2).getSSID();
          b = ((WifiInfo)localObject2).getBSSID();
        }
        localObject2 = localNetworkInfo.getExtraInfo();
        if (localObject2 == null)
        {
          a = "";
          l = 0;
          c = false;
          n = "";
        }
      }
      else
      {
        j = false;
        continue;
      }
      a = ((String)localObject2).trim().toLowerCase();
      if (i1 == 0)
      {
        i1 = localObject1.getSubtype();
        if ((i1 != 1) && (i1 != 2) && (i1 != 4)) {
          break label248;
        }
      }
      label248:
      for (l = 2;; l = 3)
      {
        m = g().intValue();
        if (!a.contains(f)) {
          break label255;
        }
        c = true;
        n = "10.0.0.172";
        break;
      }
      label255:
      if (a.contains(e))
      {
        c = true;
        n = "10.0.0.172";
      }
      else if (a.contains(g))
      {
        c = true;
        n = "10.0.0.172";
      }
      else if (a.contains(h))
      {
        c = true;
        n = "10.0.0.200";
      }
      else
      {
        c = false;
        n = "";
      }
    }
  }
  
  public static int c()
  {
    try
    {
      int i1 = l;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int d()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean e()
  {
    return j;
  }
  
  public static void f()
  {
    try
    {
      ax.b(d, "showApnInfo... Apn:" + a + ",sIsNetworkOk:" + j + ",sNetType:" + l + ",sIsProxy:" + c + ",sProxyAddress:" + n);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static Integer g()
  {
    int i3 = 3;
    int i2 = 2;
    int i1 = 1;
    for (;;)
    {
      Object localObject4;
      try
      {
        if (l == 1)
        {
          localObject1 = k;
          if ((localObject1 == null) || (((String)localObject1).length() <= 0))
          {
            localObject1 = Integer.valueOf(0);
            m = ((Integer)localObject1).intValue();
            i1 = m;
            return Integer.valueOf(i1);
          }
          localObject1 = ((String)localObject1).toLowerCase();
          if (!((String)localObject1).contains("cmcc")) {
            break label374;
          }
          if (!((String)localObject1).contains("chinanet")) {
            break label371;
          }
          i1 = i3;
          if (!((String)localObject1).contains("chinaunicom")) {
            break label368;
          }
          i1 = i2;
          localObject1 = Integer.valueOf(i1);
          continue;
        }
        if ((l != 2) && (l != 3)) {
          break label361;
        }
        localObject4 = i;
        Object localObject1 = a;
        localObject4 = (TelephonyManager)((Context)localObject4).getSystemService("phone");
        if ((localObject4 == null) || (((TelephonyManager)localObject4).getSimState() != 5)) {
          break label244;
        }
        localObject4 = ((TelephonyManager)localObject4).getSimOperator();
        if (((String)localObject4).length() <= 0) {
          break label244;
        }
        if ((((String)localObject4).equals("46000")) || (((String)localObject4).equals("46002")))
        {
          localObject1 = Integer.valueOf(1);
          m = ((Integer)localObject1).intValue();
          continue;
        }
        if (!((String)localObject4).equals("46001")) {
          break label225;
        }
      }
      finally {}
      Object localObject3 = Integer.valueOf(2);
      continue;
      label225:
      if (((String)localObject4).equals("46003"))
      {
        localObject3 = Integer.valueOf(3);
      }
      else
      {
        label244:
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).toLowerCase();
          if ((((String)localObject3).contains("cmnet")) || (((String)localObject3).contains("cmwap")))
          {
            localObject3 = Integer.valueOf(1);
            continue;
          }
          if ((((String)localObject3).contains("uninet")) || (((String)localObject3).contains("uniwap")) || (((String)localObject3).contains("3gnet")) || (((String)localObject3).contains("3gwap")))
          {
            localObject3 = Integer.valueOf(2);
            continue;
          }
          if ((((String)localObject3).contains("ctnet")) || (((String)localObject3).contains("ctwap")))
          {
            localObject3 = Integer.valueOf(3);
            continue;
          }
        }
        localObject3 = Integer.valueOf(0);
        continue;
        label361:
        m = 0;
        continue;
        label368:
        continue;
        label371:
        continue;
        label374:
        i1 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.aw
 * JD-Core Version:    0.7.0.1
 */