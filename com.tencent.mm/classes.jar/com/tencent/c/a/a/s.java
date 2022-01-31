package com.tencent.c.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s
{
  static g a(g paramg1, g paramg2)
  {
    AppMethodBeat.i(125754);
    if ((paramg1 != null) && (paramg2 != null))
    {
      if (paramg1.a(paramg2) >= 0)
      {
        AppMethodBeat.o(125754);
        return paramg1;
      }
      AppMethodBeat.o(125754);
      return paramg2;
    }
    if (paramg1 != null)
    {
      AppMethodBeat.o(125754);
      return paramg1;
    }
    if (paramg2 != null)
    {
      AppMethodBeat.o(125754);
      return paramg2;
    }
    AppMethodBeat.o(125754);
    return null;
  }
  
  static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(125758);
    if (cI(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
    AppMethodBeat.o(125758);
  }
  
  static boolean aO(Context paramContext)
  {
    AppMethodBeat.i(125757);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getTypeName() != null))
      {
        boolean bool = paramContext.getTypeName().equalsIgnoreCase("WIFI");
        if (bool)
        {
          AppMethodBeat.o(125757);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(125757);
    }
    return false;
  }
  
  static String aP(Context paramContext)
  {
    AppMethodBeat.i(125762);
    if (q(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null)
        {
          AppMethodBeat.o(125762);
          return "";
        }
        paramContext = paramContext.getConnectionInfo().getMacAddress();
        AppMethodBeat.o(125762);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        "get wifi address error".concat(String.valueOf(paramContext));
        zU();
        AppMethodBeat.o(125762);
        return "";
      }
    }
    zU();
    AppMethodBeat.o(125762);
    return "";
  }
  
  static String aQ(Context paramContext)
  {
    AppMethodBeat.i(125764);
    try
    {
      paramContext = getWifiInfo(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        AppMethodBeat.o(125764);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      zV();
      AppMethodBeat.o(125764);
    }
    return null;
  }
  
  static String aR(Context paramContext)
  {
    AppMethodBeat.i(125765);
    try
    {
      paramContext = getWifiInfo(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getSSID();
        AppMethodBeat.o(125765);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      zV();
      AppMethodBeat.o(125765);
    }
    return null;
  }
  
  static JSONArray aS(Context paramContext)
  {
    AppMethodBeat.i(125766);
    try
    {
      if ((q(paramContext, "android.permission.INTERNET")) && (q(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getScanResults();
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            Collections.sort(paramContext, new Comparator() {});
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              int j = paramContext.size();
              if (i >= j) {}
              while (i >= 10)
              {
                AppMethodBeat.o(125766);
                return localJSONArray;
              }
              ScanResult localScanResult = (ScanResult)paramContext.get(i);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("bs", localScanResult.BSSID);
              localJSONObject.put("ss", localScanResult.SSID);
              localJSONArray.put(localJSONObject);
              i += 1;
            }
          }
        }
      }
      else
      {
        zU();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        zV();
      }
    }
    AppMethodBeat.o(125766);
    return null;
  }
  
  static String aT(Context paramContext)
  {
    AppMethodBeat.i(125767);
    try
    {
      if (q(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        paramContext = Environment.getExternalStorageState();
        if ((paramContext != null) && (paramContext.equals("mounted")))
        {
          paramContext = Environment.getExternalStorageDirectory().getPath();
          if (paramContext != null)
          {
            paramContext = new StatFs(paramContext);
            long l1 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
            long l2 = paramContext.getAvailableBlocks();
            paramContext = String.valueOf(paramContext.getBlockSize() * l2 / 1000000L) + "/" + String.valueOf(l1);
            AppMethodBeat.o(125767);
            return paramContext;
          }
        }
      }
      else
      {
        zU();
        AppMethodBeat.o(125767);
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      zW();
      AppMethodBeat.o(125767);
    }
    return null;
  }
  
  static String aU(Context paramContext)
  {
    AppMethodBeat.i(125769);
    for (;;)
    {
      try
      {
        if ((!q(paramContext, "android.permission.INTERNET")) || (!q(paramContext, "android.permission.ACCESS_NETWORK_STATE"))) {
          continue;
        }
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isConnected())) {
          continue;
        }
        str1 = paramContext.getTypeName();
        str2 = paramContext.getExtraInfo();
        if (str1 == null) {
          continue;
        }
        if (!str1.equalsIgnoreCase("WIFI")) {
          continue;
        }
        paramContext = "WIFI";
      }
      catch (Throwable paramContext)
      {
        String str1;
        String str2;
        paramContext = null;
        zV();
        continue;
        paramContext = null;
        continue;
        paramContext = str2;
        if (str2 != null) {
          continue;
        }
        paramContext = str1;
        continue;
      }
      AppMethodBeat.o(125769);
      return paramContext;
      if (!str1.equalsIgnoreCase("MOBILE")) {
        continue;
      }
      paramContext = str2;
      if (str2 == null)
      {
        paramContext = "MOBILE";
        continue;
        zU();
        paramContext = null;
      }
    }
  }
  
  static boolean b(g paramg1, g paramg2)
  {
    AppMethodBeat.i(125755);
    if ((paramg1 != null) && (paramg2 != null))
    {
      if (paramg1.a(paramg2) == 0)
      {
        AppMethodBeat.o(125755);
        return true;
      }
      AppMethodBeat.o(125755);
      return false;
    }
    if ((paramg1 == null) && (paramg2 == null))
    {
      AppMethodBeat.o(125755);
      return true;
    }
    AppMethodBeat.o(125755);
    return false;
  }
  
  static boolean cI(String paramString)
  {
    AppMethodBeat.i(125752);
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(125752);
      return false;
    }
    AppMethodBeat.o(125752);
    return true;
  }
  
  static boolean cJ(String paramString)
  {
    AppMethodBeat.i(125753);
    if ((paramString != null) && (paramString.trim().length() >= 40))
    {
      AppMethodBeat.o(125753);
      return true;
    }
    AppMethodBeat.o(125753);
    return false;
  }
  
  static String decode(String paramString)
  {
    AppMethodBeat.i(125759);
    if (paramString == null)
    {
      AppMethodBeat.o(125759);
      return null;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      AppMethodBeat.o(125759);
      return paramString;
    }
    try
    {
      String str = new String(l.encrypt(Base64.decode(paramString.getBytes("UTF-8"), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      AppMethodBeat.o(125759);
      return str;
    }
    catch (Throwable localThrowable)
    {
      zW();
      AppMethodBeat.o(125759);
    }
    return paramString;
  }
  
  static String encode(String paramString)
  {
    AppMethodBeat.i(125760);
    if (paramString == null)
    {
      AppMethodBeat.o(125760);
      return null;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      AppMethodBeat.o(125760);
      return paramString;
    }
    try
    {
      String str = new String(Base64.encode(l.encrypt(paramString.getBytes("UTF-8"), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      AppMethodBeat.o(125760);
      return str;
    }
    catch (Throwable localThrowable)
    {
      zW();
      AppMethodBeat.o(125760);
    }
    return paramString;
  }
  
  static String getImei(Context paramContext)
  {
    AppMethodBeat.i(125761);
    try
    {
      if (q(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null)
        {
          AppMethodBeat.o(125761);
          return paramContext;
        }
      }
      else
      {
        zU();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        zV();
      }
    }
    AppMethodBeat.o(125761);
    return "";
  }
  
  private static WifiInfo getWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(125763);
    if (q(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        AppMethodBeat.o(125763);
        return paramContext;
      }
    }
    AppMethodBeat.o(125763);
    return null;
  }
  
  static boolean q(Context paramContext, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(125756);
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        zW();
      }
    }
    AppMethodBeat.o(125756);
    return bool;
  }
  
  static void zU()
  {
    if (i.bUJ != null) {
      h localh = i.bUJ;
    }
  }
  
  static void zV()
  {
    if (i.bUJ != null) {
      h localh = i.bUJ;
    }
  }
  
  public static void zW()
  {
    if (i.bUJ != null) {
      h localh = i.bUJ;
    }
  }
  
  static String zX()
  {
    AppMethodBeat.i(125768);
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount() * l1 / 1000000L;
      localObject = String.valueOf(((StatFs)localObject).getAvailableBlocks() * l1 / 1000000L) + "/" + String.valueOf(l2);
      AppMethodBeat.o(125768);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      zV();
      AppMethodBeat.o(125768);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.s
 * JD-Core Version:    0.7.0.1
 */