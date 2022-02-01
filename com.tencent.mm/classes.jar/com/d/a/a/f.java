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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private final WifiManager bWU;
  private final LocationManager bWV;
  final PackageManager bWW;
  PackageInfo bWX;
  String bWY;
  String bWZ;
  String bXa;
  private int bXb;
  private int bXc;
  int bXd;
  int bXe;
  int bXf;
  int bXg;
  String imei;
  final Context mContext;
  final SensorManager mSensorManager;
  private String source;
  private String version;
  String versionName;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(87881);
    this.bXb = 0;
    this.bXc = 0;
    this.bXd = 0;
    this.bXe = 0;
    this.bXf = 0;
    this.bXg = 0;
    this.source = "203";
    this.version = "2.0.1";
    this.mContext = paramContext;
    this.bWU = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.bWV = ((LocationManager)this.mContext.getSystemService("location"));
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.bWW = this.mContext.getPackageManager();
    this.bWX = new PackageInfo();
    try
    {
      this.bWX = this.bWW.getPackageInfo(this.mContext.getPackageName(), 0);
      AppMethodBeat.o(87881);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(87881);
    }
  }
  
  private boolean Ah()
  {
    AppMethodBeat.i(87883);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.bWV.isProviderEnabled("gps");
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
  private boolean Ai()
  {
    AppMethodBeat.i(87884);
    boolean bool1 = false;
    boolean bool2;
    if (this.bWU != null)
    {
      bool2 = this.bWU.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.bWU.isScanAlwaysAvailable();
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
  
  private static String cl(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public final String x(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(87882);
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", cl(this.versionName));
    if (this.bWY != null)
    {
      localHashMap.put("app_label", cl(Base64.encodeToString(this.bWY.getBytes(), 0)));
      if (!Ah()) {
        break label311;
      }
      i = 1;
      label81:
      this.bXc = i;
      if ((this.bWU == null) || (!this.bWU.isWifiEnabled())) {
        break label316;
      }
      i = 1;
      label105:
      if ((i | Ai()) == 0) {
        break label321;
      }
    }
    label311:
    label316:
    label321:
    for (int i = j;; i = 0)
    {
      this.bXb = i;
      localHashMap.put("chips", Integer.toBinaryString(this.bXg | 0x0 | this.bXf << 1 | this.bXe << 2 | this.bXd << 3 | this.bXc << 4 | this.bXb << 5));
      localHashMap.put("source", this.source);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", cl(Base64.encodeToString(this.bWZ.getBytes(), 0)));
        localHashMap.put("version", cl(this.bXa));
        localHashMap.put("imei", cl(this.imei));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.f
 * JD-Core Version:    0.7.0.1
 */