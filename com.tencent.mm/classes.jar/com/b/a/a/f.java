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
  private final LocationManager bmA;
  final SensorManager bmB;
  final PackageManager bmC;
  PackageInfo bmD;
  String bmE;
  String bmF;
  String bmG;
  private int bmH;
  private int bmI;
  int bmJ;
  int bmK;
  int bmL;
  int bmM;
  private final WifiManager bmz;
  String imei;
  final Context mContext;
  private String source;
  private String version;
  String versionName;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(55536);
    this.bmH = 0;
    this.bmI = 0;
    this.bmJ = 0;
    this.bmK = 0;
    this.bmL = 0;
    this.bmM = 0;
    this.source = "203";
    this.version = "2.0.1";
    this.mContext = paramContext;
    this.bmz = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.bmA = ((LocationManager)this.mContext.getSystemService("location"));
    this.bmB = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.bmC = this.mContext.getPackageManager();
    this.bmD = new PackageInfo();
    try
    {
      this.bmD = this.bmC.getPackageInfo(this.mContext.getPackageName(), 0);
      AppMethodBeat.o(55536);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(55536);
    }
  }
  
  private static String bo(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private boolean ti()
  {
    AppMethodBeat.i(55538);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.bmA.isProviderEnabled("gps");
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    AppMethodBeat.o(55538);
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  private boolean tj()
  {
    AppMethodBeat.i(55539);
    boolean bool1 = false;
    boolean bool2;
    if (this.bmz != null)
    {
      bool2 = this.bmz.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.bmz.isScanAlwaysAvailable();
      }
      AppMethodBeat.o(55539);
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
  
  public final String s(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(55537);
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", bo(this.versionName));
    if (this.bmE != null)
    {
      localHashMap.put("app_label", bo(Base64.encodeToString(this.bmE.getBytes(), 0)));
      if (!ti()) {
        break label311;
      }
      i = 1;
      label81:
      this.bmI = i;
      if ((this.bmz == null) || (!this.bmz.isWifiEnabled())) {
        break label316;
      }
      i = 1;
      label105:
      if ((i | tj()) == 0) {
        break label321;
      }
    }
    label311:
    label316:
    label321:
    for (int i = j;; i = 0)
    {
      this.bmH = i;
      localHashMap.put("chips", Integer.toBinaryString(this.bmM | 0x0 | this.bmL << 1 | this.bmK << 2 | this.bmJ << 3 | this.bmI << 4 | this.bmH << 5));
      localHashMap.put("source", this.source);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", bo(Base64.encodeToString(this.bmF.getBytes(), 0)));
        localHashMap.put("version", bo(this.bmG));
        localHashMap.put("imei", bo(this.imei));
        paramArrayOfByte = paramArrayOfByte.put("attribute", new JSONObject(localHashMap)).toString();
        AppMethodBeat.o(55537);
        return paramArrayOfByte;
      }
      catch (JSONException paramArrayOfByte)
      {
        AppMethodBeat.o(55537);
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
 * Qualified Name:     com.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */