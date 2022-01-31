package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.net.wifi.WifiInfo;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
{
  static void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    long l = bk.UY();
    String str2 = "";
    String str1 = "";
    WifiInfo localWifiInfo = aq.getWifiInfo(ae.getContext());
    if (localWifiInfo != null)
    {
      str2 = localWifiInfo.getSSID();
      str1 = localWifiInfo.getBSSID();
    }
    paramString1 = new StringBuilder().append(paramString3).append(",").append(paramString2).append(",").append(paramString1).append(",").append(l).append(",").append(paramLong).append(",").append(paramInt).append(",");
    int i;
    switch (aq.getNetType(ae.getContext()))
    {
    case 9: 
    default: 
      i = 6;
    }
    for (;;)
    {
      paramString1 = i + "," + str2 + "," + str1 + ",,";
      y.v("MicroMsg.MiniProgramNavigatorAdReportHelper", "closeType:%d stayTime:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      AdReportCgiHelper.a(16004, paramString1, null);
      return;
      i = 255;
      continue;
      i = 1;
      continue;
      i = 4;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  public static void a(String paramString1, String paramString2, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {}
    String str;
    do
    {
      return;
      str = paramAppBrandStatObject.gxg;
    } while (bk.bl(str));
    g.a(paramString1, new f.1(paramString1, paramString2, str, System.currentTimeMillis(), paramAppBrandStatObject));
  }
  
  public static void b(String paramString1, String paramString2, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {}
    while (bk.bl(paramAppBrandStatObject.gxg)) {
      return;
    }
    a(4, paramString1, paramString2, paramAppBrandStatObject.gxg, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f
 * JD-Core Version:    0.7.0.1
 */