package com.tencent.b.a.a;

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
  static void Uf()
  {
    if (i.dfP != null) {
      h localh = i.dfP;
    }
  }
  
  static void Ug()
  {
    if (i.dfP != null) {
      h localh = i.dfP;
    }
  }
  
  public static void Uh()
  {
    if (i.dfP != null) {
      h localh = i.dfP;
    }
  }
  
  static String Ui()
  {
    AppMethodBeat.i(87650);
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount() * l1 / 1000000L;
      localObject = String.valueOf(((StatFs)localObject).getAvailableBlocks() * l1 / 1000000L) + "/" + String.valueOf(l2);
      AppMethodBeat.o(87650);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Ug();
      AppMethodBeat.o(87650);
    }
    return "";
  }
  
  static g a(g paramg1, g paramg2)
  {
    AppMethodBeat.i(87636);
    if ((paramg1 != null) && (paramg2 != null))
    {
      if (paramg1.a(paramg2) >= 0)
      {
        AppMethodBeat.o(87636);
        return paramg1;
      }
      AppMethodBeat.o(87636);
      return paramg2;
    }
    if (paramg1 != null)
    {
      AppMethodBeat.o(87636);
      return paramg1;
    }
    if (paramg2 != null)
    {
      AppMethodBeat.o(87636);
      return paramg2;
    }
    AppMethodBeat.o(87636);
    return null;
  }
  
  static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(87640);
    if (eY(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
    AppMethodBeat.o(87640);
  }
  
  static boolean b(g paramg1, g paramg2)
  {
    AppMethodBeat.i(87637);
    if ((paramg1 != null) && (paramg2 != null))
    {
      if (paramg1.a(paramg2) == 0)
      {
        AppMethodBeat.o(87637);
        return true;
      }
      AppMethodBeat.o(87637);
      return false;
    }
    if ((paramg1 == null) && (paramg2 == null))
    {
      AppMethodBeat.o(87637);
      return true;
    }
    AppMethodBeat.o(87637);
    return false;
  }
  
  static String bA(Context paramContext)
  {
    AppMethodBeat.i(87651);
    for (;;)
    {
      try
      {
        if ((!checkPermission(paramContext, "android.permission.INTERNET")) || (!checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE"))) {
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
        Ug();
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
      AppMethodBeat.o(87651);
      return paramContext;
      if (!str1.equalsIgnoreCase("MOBILE")) {
        continue;
      }
      paramContext = str2;
      if (str2 == null)
      {
        paramContext = "MOBILE";
        continue;
        Uf();
        paramContext = null;
      }
    }
  }
  
  static boolean bt(Context paramContext)
  {
    AppMethodBeat.i(87639);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getTypeName() != null))
      {
        boolean bool = paramContext.getTypeName().equalsIgnoreCase("WIFI");
        if (bool)
        {
          AppMethodBeat.o(87639);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(87639);
    }
    return false;
  }
  
  static String bu(Context paramContext)
  {
    AppMethodBeat.i(87643);
    try
    {
      if (checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null)
        {
          AppMethodBeat.o(87643);
          return paramContext;
        }
      }
      else
      {
        Uf();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Ug();
      }
    }
    AppMethodBeat.o(87643);
    return "";
  }
  
  static String bv(Context paramContext)
  {
    AppMethodBeat.i(87644);
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null)
        {
          AppMethodBeat.o(87644);
          return "";
        }
        paramContext = paramContext.getConnectionInfo().getMacAddress();
        AppMethodBeat.o(87644);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        "get wifi address error".concat(String.valueOf(paramContext));
        Uf();
        AppMethodBeat.o(87644);
        return "";
      }
    }
    Uf();
    AppMethodBeat.o(87644);
    return "";
  }
  
  static String bw(Context paramContext)
  {
    AppMethodBeat.i(87646);
    try
    {
      paramContext = getWifiInfo(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        AppMethodBeat.o(87646);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      Ug();
      AppMethodBeat.o(87646);
    }
    return null;
  }
  
  static String bx(Context paramContext)
  {
    AppMethodBeat.i(87647);
    try
    {
      paramContext = getWifiInfo(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getSSID();
        AppMethodBeat.o(87647);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      Ug();
      AppMethodBeat.o(87647);
    }
    return null;
  }
  
  static JSONArray by(Context paramContext)
  {
    AppMethodBeat.i(87648);
    try
    {
      if ((checkPermission(paramContext, "android.permission.INTERNET")) && (checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
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
                AppMethodBeat.o(87648);
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
        Uf();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Ug();
      }
    }
    AppMethodBeat.o(87648);
    return null;
  }
  
  static String bz(Context paramContext)
  {
    AppMethodBeat.i(87649);
    try
    {
      if (checkPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
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
            AppMethodBeat.o(87649);
            return paramContext;
          }
        }
      }
      else
      {
        Uf();
        AppMethodBeat.o(87649);
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      Uh();
      AppMethodBeat.o(87649);
    }
    return null;
  }
  
  static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(87638);
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
        Uh();
      }
    }
    AppMethodBeat.o(87638);
    return bool;
  }
  
  static String decode(String paramString)
  {
    AppMethodBeat.i(87641);
    if (paramString == null)
    {
      AppMethodBeat.o(87641);
      return null;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      AppMethodBeat.o(87641);
      return paramString;
    }
    try
    {
      String str = new String(l.encrypt(Base64.decode(paramString.getBytes("UTF-8"), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      AppMethodBeat.o(87641);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Uh();
      AppMethodBeat.o(87641);
    }
    return paramString;
  }
  
  static boolean eY(String paramString)
  {
    AppMethodBeat.i(87634);
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(87634);
      return false;
    }
    AppMethodBeat.o(87634);
    return true;
  }
  
  static boolean eZ(String paramString)
  {
    AppMethodBeat.i(87635);
    if ((paramString != null) && (paramString.trim().length() >= 40))
    {
      AppMethodBeat.o(87635);
      return true;
    }
    AppMethodBeat.o(87635);
    return false;
  }
  
  static String encode(String paramString)
  {
    AppMethodBeat.i(87642);
    if (paramString == null)
    {
      AppMethodBeat.o(87642);
      return null;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      AppMethodBeat.o(87642);
      return paramString;
    }
    try
    {
      String str = new String(Base64.encode(l.encrypt(paramString.getBytes("UTF-8"), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      AppMethodBeat.o(87642);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Uh();
      AppMethodBeat.o(87642);
    }
    return paramString;
  }
  
  private static WifiInfo getWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(87645);
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        AppMethodBeat.o(87645);
        return paramContext;
      }
    }
    AppMethodBeat.o(87645);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.s
 * JD-Core Version:    0.7.0.1
 */