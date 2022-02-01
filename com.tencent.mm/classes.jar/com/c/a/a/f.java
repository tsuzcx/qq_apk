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
  private final WifiManager bOZ;
  private final LocationManager bPa;
  final PackageManager bPb;
  PackageInfo bPc;
  String bPd;
  String bPe;
  String bPf;
  private int bPg;
  private int bPh;
  int bPi;
  int bPj;
  int bPk;
  int bPl;
  String imei;
  final Context mContext;
  final SensorManager mSensorManager;
  private String source;
  private String version;
  String versionName;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(87881);
    this.bPg = 0;
    this.bPh = 0;
    this.bPi = 0;
    this.bPj = 0;
    this.bPk = 0;
    this.bPl = 0;
    this.source = "203";
    this.version = "2.0.1";
    this.mContext = paramContext;
    this.bOZ = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.bPa = ((LocationManager)this.mContext.getSystemService("location"));
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.bPb = this.mContext.getPackageManager();
    this.bPc = new PackageInfo();
    try
    {
      this.bPc = this.bPb.getPackageInfo(this.mContext.getPackageName(), 0);
      AppMethodBeat.o(87881);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(87881);
    }
  }
  
  private static String bA(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private boolean yW()
  {
    AppMethodBeat.i(87883);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.bPa.isProviderEnabled("gps");
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
  private boolean yX()
  {
    AppMethodBeat.i(87884);
    boolean bool1 = false;
    boolean bool2;
    if (this.bOZ != null)
    {
      bool2 = this.bOZ.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.bOZ.isScanAlwaysAvailable();
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
  
  public final String z(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(87882);
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", bA(this.versionName));
    if (this.bPd != null)
    {
      localHashMap.put("app_label", bA(Base64.encodeToString(this.bPd.getBytes(), 0)));
      if (!yW()) {
        break label311;
      }
      i = 1;
      label81:
      this.bPh = i;
      if ((this.bOZ == null) || (!this.bOZ.isWifiEnabled())) {
        break label316;
      }
      i = 1;
      label105:
      if ((i | yX()) == 0) {
        break label321;
      }
    }
    label311:
    label316:
    label321:
    for (int i = j;; i = 0)
    {
      this.bPg = i;
      localHashMap.put("chips", Integer.toBinaryString(this.bPl | 0x0 | this.bPk << 1 | this.bPj << 2 | this.bPi << 3 | this.bPh << 4 | this.bPg << 5));
      localHashMap.put("source", this.source);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", bA(Base64.encodeToString(this.bPe.getBytes(), 0)));
        localHashMap.put("version", bA(this.bPf));
        localHashMap.put("imei", bA(this.imei));
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