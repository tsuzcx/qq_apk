package com.b.a.a;

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
  private final WifiManager chC;
  private final LocationManager chD;
  final PackageManager chE;
  String chF;
  String chG;
  String chH;
  private int chI;
  private int chJ;
  int chK;
  int chL;
  int chM;
  int chN;
  String imei;
  final Context mContext;
  PackageInfo mPackageInfo;
  final SensorManager mSensorManager;
  private String source;
  private String version;
  String versionName;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(87881);
    this.chI = 0;
    this.chJ = 0;
    this.chK = 0;
    this.chL = 0;
    this.chM = 0;
    this.chN = 0;
    this.source = "203";
    this.version = "2.0.1";
    this.mContext = paramContext;
    this.chC = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.chD = ((LocationManager)this.mContext.getSystemService("location"));
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.chE = this.mContext.getPackageManager();
    this.mPackageInfo = new PackageInfo();
    try
    {
      this.mPackageInfo = this.chE.getPackageInfo(this.mContext.getPackageName(), 0);
      AppMethodBeat.o(87881);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(87881);
    }
  }
  
  private boolean Ja()
  {
    AppMethodBeat.i(87883);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.chD.isProviderEnabled("gps");
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
  private boolean Jb()
  {
    AppMethodBeat.i(87884);
    boolean bool1 = false;
    boolean bool2;
    if (this.chC != null)
    {
      bool2 = this.chC.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.chC.isScanAlwaysAvailable();
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
  
  private static String cA(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public final String L(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(87882);
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", cA(this.versionName));
    if (this.chF != null)
    {
      localHashMap.put("app_label", cA(Base64.encodeToString(this.chF.getBytes(), 0)));
      if (!Ja()) {
        break label311;
      }
      i = 1;
      label81:
      this.chJ = i;
      if ((this.chC == null) || (!this.chC.isWifiEnabled())) {
        break label316;
      }
      i = 1;
      label105:
      if ((i | Jb()) == 0) {
        break label321;
      }
    }
    label311:
    label316:
    label321:
    for (int i = j;; i = 0)
    {
      this.chI = i;
      localHashMap.put("chips", Integer.toBinaryString(this.chN | 0x0 | this.chM << 1 | this.chL << 2 | this.chK << 3 | this.chJ << 4 | this.chI << 5));
      localHashMap.put("source", this.source);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", cA(Base64.encodeToString(this.chG.getBytes(), 0)));
        localHashMap.put("version", cA(this.chH));
        localHashMap.put("imei", cA(this.imei));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */