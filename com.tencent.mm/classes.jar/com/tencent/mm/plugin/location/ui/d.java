package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public final class d
{
  public Context context;
  public int ewz = -1;
  private ActivityManager jTG;
  public int lEP = 0;
  public int lEQ = 0;
  public boolean lER = false;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.jTG = ((ActivityManager)paramContext.getSystemService("activity"));
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    if ((paramBoolean) || (!paramLocationInfo2.bdN()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.lCJ + "," + paramLocationInfo1.lCK + "?z=" + paramLocationInfo1.lCL));
      paramContext.setPackage("com.baidu.BaiduMap");
      return paramContext;
    }
    String str = a(paramContext, paramLocationInfo2);
    if (!bk.bl(str))
    {
      paramLocationInfo2 = String.format("name:%s|latlng:%f,%f", new Object[] { str, Double.valueOf(paramLocationInfo2.lCJ), Double.valueOf(paramLocationInfo2.lCK) });
      paramContext = a(paramContext, paramLocationInfo1);
      if (bk.bl(paramContext)) {
        break label293;
      }
    }
    label293:
    for (paramContext = String.format("name:%s|latlng:%f,%f", new Object[] { paramContext, Double.valueOf(paramLocationInfo1.lCJ), Double.valueOf(paramLocationInfo1.lCK) });; paramContext = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo1.lCJ), Double.valueOf(paramLocationInfo1.lCK) }))
    {
      paramContext = String.format("intent://map/direction?origin=%s&destination=%s&mode=driving&coord_type=gcj02", new Object[] { paramLocationInfo2, paramContext });
      y.d("MicroMsg.MapHelper", "url " + paramContext);
      try
      {
        paramContext = paramContext + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
        y.d("MicroMsg.MapHelper", "all: " + paramContext);
        paramContext = Intent.getIntent(paramContext);
        return paramContext;
      }
      catch (URISyntaxException paramContext)
      {
        y.printErrStackTrace("MicroMsg.MapHelper", paramContext, "", new Object[0]);
      }
      paramLocationInfo2 = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.lCJ), Double.valueOf(paramLocationInfo2.lCK) });
      break;
    }
    return null;
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) || (!paramLocationInfo2.bdN()))
    {
      paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.lCJ + "," + paramLocationInfo1.lCK + "?z=" + paramLocationInfo1.lCL));
      paramLocationInfo2.setPackage(paramString);
    }
    Object localObject;
    do
    {
      return paramLocationInfo2;
      String str = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.lCJ), Double.valueOf(paramLocationInfo2.lCK), Double.valueOf(paramLocationInfo1.lCJ), Double.valueOf(paramLocationInfo1.lCK) });
      localObject = str;
      if (!bk.bl(paramLocationInfo2.lCM))
      {
        localObject = str;
        if (!bk.bl(paramLocationInfo1.lCM)) {
          localObject = str + String.format("&from=%s&to=%s", new Object[] { paramLocationInfo2.lCM, paramLocationInfo1.lCM });
        }
      }
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      ((Intent)localObject).setPackage(paramString);
      paramLocationInfo2 = (LocationInfo)localObject;
    } while (bk.i(paramContext, (Intent)localObject));
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.lCJ + "," + paramLocationInfo1.lCK));
    paramContext.setPackage(paramString);
    return paramContext;
  }
  
  private static Intent a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    if ((paramBoolean) || (!paramLocationInfo2.bdN()))
    {
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.lCJ + "," + paramLocationInfo1.lCK + "?z=" + paramLocationInfo1.lCL));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      return paramLocationInfo1;
    }
    if (bk.bl(paramLocationInfo1.lCN)) {}
    for (String str = "zh-cn";; str = paramLocationInfo1.lCN)
    {
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + str, new Object[] { Double.valueOf(paramLocationInfo2.lCJ), Double.valueOf(paramLocationInfo2.lCK), Double.valueOf(paramLocationInfo1.lCJ), Double.valueOf(paramLocationInfo1.lCK) })));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      return paramLocationInfo1;
    }
  }
  
  private static String a(Context paramContext, LocationInfo paramLocationInfo)
  {
    paramContext = paramContext.getString(a.h.location_conversation);
    if ((!bk.bl(paramLocationInfo.bVA)) && (!paramLocationInfo.bVA.equals(paramContext))) {
      return paramLocationInfo.bVA;
    }
    if (!bk.bl(paramLocationInfo.lCM)) {
      return paramLocationInfo.lCM;
    }
    return "";
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    if ((paramBoolean) || (!paramLocationInfo2.bdN()))
    {
      paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.lCJ + "," + paramLocationInfo1.lCK + "?z=" + paramLocationInfo1.lCL));
      paramLocationInfo2.setPackage("com.tencent.map");
    }
    Object localObject;
    do
    {
      return paramLocationInfo2;
      String str = paramLocationInfo1.lCQ;
      localObject = str;
      if (!bk.bl(paramLocationInfo1.lCQ))
      {
        localObject = str;
        if (paramLocationInfo1.lCQ.startsWith("qqmap_")) {
          localObject = paramLocationInfo1.lCQ.substring(6);
        }
      }
      paramLocationInfo2 = a(paramContext, paramLocationInfo2);
      str = a(paramContext, paramLocationInfo1);
      paramLocationInfo2 = String.format("qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client", new Object[] { localObject, Double.valueOf(paramLocationInfo1.lCJ), Double.valueOf(paramLocationInfo1.lCK), URLEncoder.encode(paramLocationInfo2), URLEncoder.encode(str) });
      y.d("MicroMsg.MapHelper", "tencentluxian, url=%s", new Object[] { paramLocationInfo2 });
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramLocationInfo2));
      ((Intent)localObject).setPackage("com.tencent.map");
      paramLocationInfo2 = (LocationInfo)localObject;
    } while (bk.i(paramContext, (Intent)localObject));
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.lCJ + "," + paramLocationInfo1.lCK));
    paramContext.setPackage("com.tencent.map");
    return paramContext;
  }
  
  public static int bem()
  {
    y.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
    return 16;
  }
  
  public final void a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, String paramString, boolean paramBoolean)
  {
    PackageManager localPackageManager;
    if ("com.tencent.map".equals(paramString)) {
      if (paramBoolean)
      {
        h.nFQ.f(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
        localPackageManager = this.context.getPackageManager();
        if (!"com.google.android.apps.maps".equals(paramString)) {
          break label231;
        }
        localObject = a(paramLocationInfo1, paramLocationInfo2, false);
        paramString = (String)localObject;
        if (!bk.i(this.context, (Intent)localObject)) {
          paramString = a(paramLocationInfo1, paramLocationInfo2, true);
        }
        h.nFQ.f(10997, new Object[] { "4", "", Integer.valueOf(0), Integer.valueOf(0) });
        this.context.startActivity(paramString);
      }
    }
    label231:
    PackageInfo localPackageInfo;
    label571:
    do
    {
      do
      {
        do
        {
          return;
          h.nFQ.f(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          break;
          if (paramBoolean)
          {
            h.nFQ.f(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
            break;
          }
          h.nFQ.f(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          break;
          if ("com.baidu.BaiduMap".equals(paramString))
          {
            localObject = a(this.context, paramLocationInfo1, paramLocationInfo2, false);
            paramString = (String)localObject;
            if (!bk.i(this.context, (Intent)localObject)) {
              paramString = a(this.context, paramLocationInfo1, paramLocationInfo2, true);
            }
            paramLocationInfo1 = e.aB(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(localPackageManager).toString();
            h.nFQ.f(10997, new Object[] { "5", paramLocationInfo1, Integer.valueOf(0), Integer.valueOf(0) });
            this.context.startActivity(paramString);
            return;
          }
          if ("com.tencent.map".equals(paramString))
          {
            localObject = b(this.context, paramLocationInfo1, paramLocationInfo2, false);
            paramString = (String)localObject;
            if (!bk.i(this.context, (Intent)localObject)) {
              paramString = b(this.context, paramLocationInfo1, paramLocationInfo2, true);
            }
            h.nFQ.f(10997, new Object[] { "2", "", Integer.valueOf(0), Integer.valueOf(0) });
            this.context.startActivity(paramString);
            return;
          }
          if (!"com.autonavi.minimap".equals(paramString)) {
            break label571;
          }
          localPackageInfo = e.aB(this.context, paramString);
        } while (localPackageInfo == null);
        localIntent = a(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
        localObject = localIntent;
        if (!bk.i(this.context, localIntent)) {
          localObject = a(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);
        }
        paramLocationInfo1 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
        h.nFQ.f(10997, new Object[] { "5", paramLocationInfo1, Integer.valueOf(0), Integer.valueOf(0) });
        this.context.startActivity((Intent)localObject);
        return;
      } while (!"com.sogou.map.android.maps".equals(paramString));
      localPackageInfo = e.aB(this.context, paramString);
    } while (localPackageInfo == null);
    Intent localIntent = a(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
    Object localObject = localIntent;
    if (!bk.i(this.context, localIntent)) {
      localObject = a(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);
    }
    paramLocationInfo1 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
    h.nFQ.f(10997, new Object[] { "5", paramLocationInfo1, Integer.valueOf(0), Integer.valueOf(0) });
    this.context.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.d
 * JD-Core Version:    0.7.0.1
 */