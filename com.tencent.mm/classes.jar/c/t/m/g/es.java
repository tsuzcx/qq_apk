package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class es
{
  public static boolean a = false;
  private static long b = 0L;
  private static boolean c = false;
  
  public static int a(WifiManager paramWifiManager)
  {
    int i = 4;
    if (paramWifiManager != null) {}
    try
    {
      i = paramWifiManager.getWifiState();
      return i;
    }
    catch (Throwable paramWifiManager) {}
    return 4;
  }
  
  public static String a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramList = paramList.iterator();
    int i = 0;
    for (;;)
    {
      ScanResult localScanResult;
      if (paramList.hasNext())
      {
        localScanResult = (ScanResult)paramList.next();
        if ((localScanResult.SSID == null) || (localScanResult.SSID.length() == 0)) {}
      }
      else
      {
        try
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append('|');
          localStringBuilder2.append(localScanResult.BSSID).append(',');
          localStringBuilder2.append(Base64.encodeToString(localScanResult.SSID.getBytes("UTF-8"), 2)).append(',');
          localStringBuilder2.append(localScanResult.frequency).append(',');
          localStringBuilder2.append(Base64.encodeToString(localScanResult.capabilities.getBytes("UTF-8"), 2));
          localStringBuilder1.append(localStringBuilder2);
          i += 1;
        }
        catch (Throwable localThrowable) {}
        localStringBuilder1.insert(0, "1|" + i);
        return localStringBuilder1.toString();
      }
    }
  }
  
  public static boolean a(dg paramdg)
  {
    boolean bool2 = false;
    try
    {
      paramdg = paramdg.f;
      boolean bool1 = bool2;
      if (paramdg != null)
      {
        boolean bool3 = paramdg.isWifiEnabled();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramdg) {}
    return false;
  }
  
  public static boolean b(WifiManager paramWifiManager)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramWifiManager != null) {}
    for (bool1 = bool2;; bool1 = bool2)
    {
      try
      {
        if (System.currentTimeMillis() - b <= 3000L) {
          break label66;
        }
        bool1 = bool2;
        j.a("wifis", 6, "force scan");
        bool1 = bool2;
        bool2 = paramWifiManager.startScan();
        bool1 = bool2;
        c = bool2;
        bool1 = bool2;
        b = System.currentTimeMillis();
        bool1 = bool2;
      }
      catch (Exception paramWifiManager)
      {
        for (;;)
        {
          label66:
          a = true;
        }
      }
      finally {}
      return bool1;
      bool1 = bool2;
      j.a("wifis", 6, "force scan reject");
      bool1 = bool2;
      bool2 = c;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(dg paramdg)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    WifiManager localWifiManager = paramdg.f;
    if (localWifiManager != null)
    {
      boolean bool1 = bool3;
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          bool1 = bool3;
          if (Settings.Secure.getInt(paramdg.a.getContentResolver(), "location_mode") == 0) {
            return false;
          }
        }
        bool1 = bool3;
        bool3 = localWifiManager.isWifiEnabled();
        bool2 = bool3;
        if (!bool3)
        {
          bool1 = bool3;
          bool2 = bool3;
          if (Build.VERSION.SDK_INT >= 18)
          {
            bool1 = bool3;
            bool2 = localWifiManager.isScanAlwaysAvailable();
            return bool2;
          }
        }
      }
      catch (Throwable paramdg)
      {
        bool2 = bool1;
        if ((paramdg instanceof SecurityException))
        {
          a = true;
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public static String c(dg paramdg)
  {
    Object localObject = paramdg.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      paramdg = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((paramdg != null) && (localObject != null))
      {
        paramdg = paramdg.getConnectionInfo();
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((paramdg != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = paramdg.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label225;
          }
          int i = paramdg.getRssi();
          if ((i < -100) || (i > -20)) {
            break label228;
          }
          paramdg = paramdg.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(paramdg);
          localStringBuilder.append("\"}");
          paramdg = localStringBuilder.toString();
          return paramdg;
        }
        return "{}";
      }
    }
    catch (Exception paramdg)
    {
      return "{}";
    }
    return "{}";
    label225:
    return "{}";
    label228:
    return "{}";
  }
  
  public static List<ScanResult> c(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramWifiManager != null) {
      localObject1 = localObject2;
    }
    try
    {
      paramWifiManager = paramWifiManager.getScanResults();
      localObject1 = paramWifiManager;
      a = false;
      localObject1 = paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        a = true;
      }
    }
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null) {
      paramWifiManager = Collections.emptyList();
    }
    return paramWifiManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.es
 * JD-Core Version:    0.7.0.1
 */