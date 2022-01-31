package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public final class d
{
  public int cFd;
  public Context context;
  private ActivityManager moa;
  public int ocd;
  public int oce;
  public boolean ocf;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(113439);
    this.ocd = 0;
    this.oce = 0;
    this.cFd = -1;
    this.ocf = false;
    this.context = paramContext;
    this.moa = ((ActivityManager)paramContext.getSystemService("activity"));
    AppMethodBeat.o(113439);
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(113441);
    if ((paramBoolean) || (!paramLocationInfo2.bLh()))
    {
      paramContext = e.c(new double[] { paramLocationInfo1.nZW, paramLocationInfo1.nZV });
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramContext[1]), Double.valueOf(paramContext[0]), Integer.valueOf(paramLocationInfo1.nZX) })));
      paramContext.setPackage("com.baidu.BaiduMap");
      AppMethodBeat.o(113441);
      return paramContext;
    }
    String str = a(paramContext, paramLocationInfo2);
    if (!bo.isNullOrNil(str))
    {
      paramLocationInfo2 = String.format("name:%s|latlng:%f,%f", new Object[] { str, Double.valueOf(paramLocationInfo2.nZV), Double.valueOf(paramLocationInfo2.nZW) });
      paramContext = a(paramContext, paramLocationInfo1);
      if (bo.isNullOrNil(paramContext)) {
        break label309;
      }
    }
    label309:
    for (paramContext = String.format("name:%s|latlng:%f,%f", new Object[] { paramContext, Double.valueOf(paramLocationInfo1.nZV), Double.valueOf(paramLocationInfo1.nZW) });; paramContext = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo1.nZV), Double.valueOf(paramLocationInfo1.nZW) }))
    {
      paramContext = String.format("intent://map/direction?origin=%s&destination=%s&mode=driving&coord_type=gcj02", new Object[] { paramLocationInfo2, paramContext });
      ab.d("MicroMsg.MapHelper", "url ".concat(String.valueOf(paramContext)));
      try
      {
        paramContext = paramContext + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
        ab.d("MicroMsg.MapHelper", "all: ".concat(String.valueOf(paramContext)));
        paramContext = Intent.getIntent(paramContext);
        AppMethodBeat.o(113441);
        return paramContext;
      }
      catch (URISyntaxException paramContext)
      {
        ab.printErrStackTrace("MicroMsg.MapHelper", paramContext, "", new Object[0]);
        AppMethodBeat.o(113441);
      }
      paramLocationInfo2 = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.nZV), Double.valueOf(paramLocationInfo2.nZW) });
      break;
    }
    return null;
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(113444);
    if ((paramBoolean) || (!paramLocationInfo2.bLh()))
    {
      paramContext = e.c(new double[] { paramLocationInfo1.nZW, paramLocationInfo1.nZV });
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramContext[1]), Double.valueOf(paramContext[0]), Integer.valueOf(paramLocationInfo1.nZX) })));
      paramContext.setPackage(paramString);
      AppMethodBeat.o(113444);
      return paramContext;
    }
    String str2 = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.nZV), Double.valueOf(paramLocationInfo2.nZW), Double.valueOf(paramLocationInfo1.nZV), Double.valueOf(paramLocationInfo1.nZW) });
    String str1 = str2;
    if (!bo.isNullOrNil(paramLocationInfo2.nZY))
    {
      str1 = str2;
      if (!bo.isNullOrNil(paramLocationInfo1.nZY)) {
        str1 = str2 + String.format("&from=%s&to=%s", new Object[] { paramLocationInfo2.nZY, paramLocationInfo1.nZY });
      }
    }
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    paramLocationInfo2.setPackage(paramString);
    if (bo.k(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(113444);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.nZV + "," + paramLocationInfo1.nZW));
    paramContext.setPackage(paramString);
    AppMethodBeat.o(113444);
    return paramContext;
  }
  
  private static Intent a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(113442);
    if ((paramBoolean) || (!paramLocationInfo2.bLh()))
    {
      paramLocationInfo2 = e.c(new double[] { paramLocationInfo1.nZW, paramLocationInfo1.nZV });
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramLocationInfo2[1]), Double.valueOf(paramLocationInfo2[0]), Integer.valueOf(paramLocationInfo1.nZX) })));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      AppMethodBeat.o(113442);
      return paramLocationInfo1;
    }
    if (bo.isNullOrNil(paramLocationInfo1.nZZ)) {}
    for (String str = "zh-cn";; str = paramLocationInfo1.nZZ)
    {
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(str)), new Object[] { Double.valueOf(paramLocationInfo2.nZV), Double.valueOf(paramLocationInfo2.nZW), Double.valueOf(paramLocationInfo1.nZV), Double.valueOf(paramLocationInfo1.nZW) })));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      AppMethodBeat.o(113442);
      return paramLocationInfo1;
    }
  }
  
  private static String a(Context paramContext, LocationInfo paramLocationInfo)
  {
    AppMethodBeat.i(113440);
    paramContext = paramContext.getString(2131301088);
    if ((!bo.isNullOrNil(paramLocationInfo.cDl)) && (!paramLocationInfo.cDl.equals(paramContext)))
    {
      paramContext = paramLocationInfo.cDl;
      AppMethodBeat.o(113440);
      return paramContext;
    }
    if (!bo.isNullOrNil(paramLocationInfo.nZY))
    {
      paramContext = paramLocationInfo.nZY;
      AppMethodBeat.o(113440);
      return paramContext;
    }
    AppMethodBeat.o(113440);
    return "";
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(113443);
    if ((paramBoolean) || (!paramLocationInfo2.bLh()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.nZV + "," + paramLocationInfo1.nZW + "?z=" + paramLocationInfo1.nZX));
      paramContext.setPackage("com.tencent.map");
      AppMethodBeat.o(113443);
      return paramContext;
    }
    String str2 = paramLocationInfo1.oac;
    String str1 = str2;
    if (!bo.isNullOrNil(paramLocationInfo1.oac))
    {
      str1 = str2;
      if (paramLocationInfo1.oac.startsWith("qqmap_")) {
        str1 = paramLocationInfo1.oac.substring(6);
      }
    }
    paramLocationInfo2 = a(paramContext, paramLocationInfo2);
    str2 = a(paramContext, paramLocationInfo1);
    paramLocationInfo2 = String.format("qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client", new Object[] { str1, Double.valueOf(paramLocationInfo1.nZV), Double.valueOf(paramLocationInfo1.nZW), URLEncoder.encode(paramLocationInfo2), URLEncoder.encode(str2) });
    ab.d("MicroMsg.MapHelper", "tencentluxian, url=%s", new Object[] { paramLocationInfo2 });
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(paramLocationInfo2));
    paramLocationInfo2.setPackage("com.tencent.map");
    if (bo.k(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(113443);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.nZV + "," + paramLocationInfo1.nZW));
    paramContext.setPackage("com.tencent.map");
    AppMethodBeat.o(113443);
    return paramContext;
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(113445);
    if ((paramBoolean) || (!paramLocationInfo2.bLh()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.nZV + "," + paramLocationInfo1.nZW + "?z=" + paramLocationInfo1.nZX));
      paramContext.setPackage(paramString);
      AppMethodBeat.o(113445);
      return paramContext;
    }
    String str2 = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.nZV), Double.valueOf(paramLocationInfo2.nZW), Double.valueOf(paramLocationInfo1.nZV), Double.valueOf(paramLocationInfo1.nZW) });
    String str1 = str2;
    if (!bo.isNullOrNil(paramLocationInfo2.nZY))
    {
      str1 = str2;
      if (!bo.isNullOrNil(paramLocationInfo1.nZY)) {
        str1 = str2 + String.format("&from=%s&to=%s", new Object[] { paramLocationInfo2.nZY, paramLocationInfo1.nZY });
      }
    }
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    paramLocationInfo2.setPackage(paramString);
    if (bo.k(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(113445);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.nZV + "," + paramLocationInfo1.nZW));
    paramContext.setPackage(paramString);
    AppMethodBeat.o(113445);
    return paramContext;
  }
  
  public static int bLF()
  {
    AppMethodBeat.i(113438);
    ab.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
    AppMethodBeat.o(113438);
    return 16;
  }
  
  public final void a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113446);
    if ("com.tencent.map".equals(paramString)) {
      if (paramBoolean) {
        h.qsU.e(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
    }
    PackageManager localPackageManager;
    Object localObject;
    for (;;)
    {
      localPackageManager = this.context.getPackageManager();
      if (!"com.google.android.apps.maps".equals(paramString)) {
        break;
      }
      localObject = a(paramLocationInfo1, paramLocationInfo2, false);
      paramString = (String)localObject;
      if (!bo.k(this.context, (Intent)localObject)) {
        paramString = a(paramLocationInfo1, paramLocationInfo2, true);
      }
      h.qsU.e(10997, new Object[] { "4", "", Integer.valueOf(0), Integer.valueOf(0) });
      this.context.startActivity(paramString);
      AppMethodBeat.o(113446);
      return;
      h.qsU.e(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
      continue;
      if (paramBoolean) {
        h.qsU.e(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
      } else {
        h.qsU.e(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      }
    }
    if ("com.baidu.BaiduMap".equals(paramString))
    {
      localObject = a(this.context, paramLocationInfo1, paramLocationInfo2, false);
      paramString = (String)localObject;
      if (!bo.k(this.context, (Intent)localObject)) {
        paramString = a(this.context, paramLocationInfo1, paramLocationInfo2, true);
      }
      paramLocationInfo1 = e.aK(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(localPackageManager).toString();
      h.qsU.e(10997, new Object[] { "5", paramLocationInfo1, Integer.valueOf(0), Integer.valueOf(0) });
      this.context.startActivity(paramString);
      AppMethodBeat.o(113446);
      return;
    }
    if ("com.tencent.map".equals(paramString))
    {
      localObject = b(this.context, paramLocationInfo1, paramLocationInfo2, false);
      paramString = (String)localObject;
      if (!bo.k(this.context, (Intent)localObject)) {
        paramString = b(this.context, paramLocationInfo1, paramLocationInfo2, true);
      }
      h.qsU.e(10997, new Object[] { "2", "", Integer.valueOf(0), Integer.valueOf(0) });
      this.context.startActivity(paramString);
      AppMethodBeat.o(113446);
      return;
    }
    PackageInfo localPackageInfo;
    Intent localIntent;
    if ("com.autonavi.minimap".equals(paramString))
    {
      localPackageInfo = e.aK(this.context, paramString);
      if (localPackageInfo != null)
      {
        localIntent = a(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
        localObject = localIntent;
        if (!bo.k(this.context, localIntent)) {
          localObject = a(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);
        }
        paramLocationInfo1 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
        h.qsU.e(10997, new Object[] { "5", paramLocationInfo1, Integer.valueOf(0), Integer.valueOf(0) });
        this.context.startActivity((Intent)localObject);
      }
      AppMethodBeat.o(113446);
      return;
    }
    if ("com.sogou.map.android.maps".equals(paramString))
    {
      localPackageInfo = e.aK(this.context, paramString);
      if (localPackageInfo != null)
      {
        localIntent = b(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
        localObject = localIntent;
        if (!bo.k(this.context, localIntent)) {
          localObject = b(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);
        }
        paramLocationInfo1 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
        h.qsU.e(10997, new Object[] { "5", paramLocationInfo1, Integer.valueOf(0), Integer.valueOf(0) });
        this.context.startActivity((Intent)localObject);
      }
    }
    AppMethodBeat.o(113446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.d
 * JD-Core Version:    0.7.0.1
 */