package com.tencent.mm.game.report.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigInteger;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String dCX = null;
  
  public static int B(Context paramContext, String paramString)
  {
    paramContext = p.getPackageInfo(paramContext, paramString);
    if (paramContext == null) {
      return 0;
    }
    return paramContext.versionCode;
  }
  
  public static String BH()
  {
    String str1 = q.zf();
    String str2 = q.zi();
    String str3 = zn();
    String str4 = q.zq();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("IMEI", str1);
      localJSONObject.put("MAC_ADDRESS", str2);
      localJSONObject.put("BLUETOOTH_ADDRESS", str3);
      localJSONObject.put("IMSI", str4);
      return fy(localJSONObject.toString());
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.ReportUtil", "getDeviceInfo: " + localJSONException.getMessage());
      }
    }
  }
  
  public static String BI()
  {
    if (dCX == null)
    {
      String str = q.zg();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < str.length() - 1)
      {
        localStringBuilder.append(Integer.toHexString(str.charAt(i)));
        i += 1;
      }
      localStringBuilder.append("00");
      dCX = localStringBuilder.toString();
    }
    return dCX;
  }
  
  public static String bv(long paramLong)
  {
    String str = new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(paramLong)).toString();
    y.d("MicroMsg.ReportUtil", "reportReadMsg, unsignedlonglong = " + str);
    return str;
  }
  
  public static String fy(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ReportUtil", paramString.getMessage());
    }
    return "";
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (aq.is3G(paramContext)) {
      return 4;
    }
    if (aq.is4G(paramContext)) {
      return 5;
    }
    switch (aq.getNetType(paramContext))
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      return 6;
    case -1: 
      return 255;
    case 0: 
      return 1;
    case 5: 
      return 2;
    }
    return 3;
  }
  
  private static String zn()
  {
    try
    {
      String str = bk.pm(BluetoothAdapter.getDefaultAdapter().getAddress());
      return str;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ReportUtil", "getBlueToothAddress failed: %s", new Object[] { bk.j(localException) });
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.a.a
 * JD-Core Version:    0.7.0.1
 */