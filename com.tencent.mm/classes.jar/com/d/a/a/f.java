package com.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private final WifiManager aVR;
  private final LocationManager aVS;
  final SensorManager aVT;
  final PackageManager aVU;
  PackageInfo aVV;
  String aVW;
  String aVX;
  String aVY;
  private int aVZ = 0;
  private int aWa = 0;
  int aWb = 0;
  int aWc = 0;
  int aWd = 0;
  int aWe = 0;
  private String aWf = "203";
  String imei;
  final Context mContext;
  private String version = "2.0.1";
  String versionName;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.aVR = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.aVS = ((LocationManager)this.mContext.getSystemService("location"));
    this.aVT = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.aVU = this.mContext.getPackageManager();
    this.aVV = new PackageInfo();
    try
    {
      this.aVV = this.aVU.getPackageInfo(this.mContext.getPackageName(), 0);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  private static String aN(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private boolean pc()
  {
    try
    {
      boolean bool = this.aVS.isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private boolean pd()
  {
    boolean bool1 = false;
    boolean bool2;
    if (this.aVR != null)
    {
      bool2 = this.aVR.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.aVR.isScanAlwaysAvailable();
      }
      return bool1;
    }
    catch (Error localError)
    {
      return bool2;
    }
    catch (Exception localException) {}
    return bool2;
  }
  
  public final String k(byte[] paramArrayOfByte)
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", aN(this.versionName));
    if (this.aVW != null)
    {
      localHashMap.put("app_label", aN(Base64.encodeToString(this.aVW.getBytes(), 0)));
      if (!pc()) {
        break label301;
      }
      i = 1;
      label76:
      this.aWa = i;
      if ((this.aVR == null) || (!this.aVR.isWifiEnabled())) {
        break label306;
      }
      i = 1;
      label100:
      if ((i | pd()) == 0) {
        break label311;
      }
    }
    label301:
    label306:
    label311:
    for (int i = j;; i = 0)
    {
      this.aVZ = i;
      localHashMap.put("chips", Integer.toBinaryString(this.aWe | 0x0 | this.aWd << 1 | this.aWc << 2 | this.aWb << 3 | this.aWa << 4 | this.aVZ << 5));
      localHashMap.put("source", this.aWf);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", aN(Base64.encodeToString(this.aVX.getBytes(), 0)));
        localHashMap.put("version", aN(this.aVY));
        localHashMap.put("imei", aN(this.imei));
        paramArrayOfByte = paramArrayOfByte.put("attribute", new JSONObject(localHashMap)).toString();
        return paramArrayOfByte;
      }
      catch (JSONException paramArrayOfByte) {}
      localHashMap.put("app_label", "");
      break;
      i = 0;
      break label76;
      i = 0;
      break label100;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.f
 * JD-Core Version:    0.7.0.1
 */