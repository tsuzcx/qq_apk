package com.c.a.a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private final WifiManager bMH;
  private final LocationManager bMI;
  final PackageManager bMJ;
  PackageInfo bMK;
  String bML;
  String bMM;
  String bMN;
  private int bMO;
  private int bMP;
  int bMQ;
  int bMR;
  int bMS;
  int bMT;
  String imei;
  final Context mContext;
  final SensorManager mSensorManager;
  private String source;
  private String version;
  String versionName;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(87881);
    this.bMO = 0;
    this.bMP = 0;
    this.bMQ = 0;
    this.bMR = 0;
    this.bMS = 0;
    this.bMT = 0;
    this.source = "203";
    this.version = "2.0.1";
    this.mContext = paramContext;
    this.bMH = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.bMI = ((LocationManager)this.mContext.getSystemService("location"));
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.bMJ = this.mContext.getPackageManager();
    this.bMK = new PackageInfo();
    try
    {
      this.bMK = this.bMJ.getPackageInfo(this.mContext.getPackageName(), 0);
      AppMethodBeat.o(87881);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(87881);
    }
  }
  
  private static String br(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private boolean yJ()
  {
    AppMethodBeat.i(87883);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.bMI.isProviderEnabled("gps");
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    AppMethodBeat.o(87883);
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  private boolean yK()
  {
    AppMethodBeat.i(87884);
    boolean bool1 = false;
    boolean bool2;
    if (this.bMH != null)
    {
      bool2 = this.bMH.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.bMH.isScanAlwaysAvailable();
      }
      AppMethodBeat.o(87884);
      return bool1;
    }
    catch (Error localError)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  public final String x(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(87882);
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", br(this.versionName));
    if (this.bML != null)
    {
      localHashMap.put("app_label", br(Base64.encodeToString(this.bML.getBytes(), 0)));
      if (!yJ()) {
        break label311;
      }
      i = 1;
      label81:
      this.bMP = i;
      if ((this.bMH == null) || (!this.bMH.isWifiEnabled())) {
        break label316;
      }
      i = 1;
      label105:
      if ((i | yK()) == 0) {
        break label321;
      }
    }
    label311:
    label316:
    label321:
    for (int i = j;; i = 0)
    {
      this.bMO = i;
      localHashMap.put("chips", Integer.toBinaryString(this.bMT | 0x0 | this.bMS << 1 | this.bMR << 2 | this.bMQ << 3 | this.bMP << 4 | this.bMO << 5));
      localHashMap.put("source", this.source);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", br(Base64.encodeToString(this.bMM.getBytes(), 0)));
        localHashMap.put("version", br(this.bMN));
        localHashMap.put("imei", br(this.imei));
        paramArrayOfByte = paramArrayOfByte.put("attribute", new JSONObject(localHashMap)).toString();
        AppMethodBeat.o(87882);
        return paramArrayOfByte;
      }
      catch (JSONException paramArrayOfByte)
      {
        AppMethodBeat.o(87882);
      }
      localHashMap.put("app_label", "");
      break;
      i = 0;
      break label81;
      i = 0;
      break label105;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */