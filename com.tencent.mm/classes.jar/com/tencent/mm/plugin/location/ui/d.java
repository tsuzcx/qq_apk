package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private ActivityManager aJm;
  public Context context;
  public int dFx;
  public int vbA;
  public boolean vbB;
  public int vbz;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(55816);
    this.vbz = 0;
    this.vbA = 0;
    this.dFx = -1;
    this.vbB = false;
    this.context = paramContext;
    this.aJm = ((ActivityManager)paramContext.getSystemService("activity"));
    AppMethodBeat.o(55816);
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(55818);
    if ((paramBoolean) || (!paramLocationInfo2.dfX()))
    {
      paramContext = e.b(new double[] { paramLocationInfo1.uZs, paramLocationInfo1.uZr });
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramContext[1]), Double.valueOf(paramContext[0]), Integer.valueOf(paramLocationInfo1.uZt) })));
      paramContext.setPackage("com.baidu.BaiduMap");
      AppMethodBeat.o(55818);
      return paramContext;
    }
    String str = a(paramContext, paramLocationInfo2);
    if (!bt.isNullOrNil(str))
    {
      paramLocationInfo2 = String.format("name:%s|latlng:%f,%f", new Object[] { str, Double.valueOf(paramLocationInfo2.uZr), Double.valueOf(paramLocationInfo2.uZs) });
      paramContext = a(paramContext, paramLocationInfo1);
      if (bt.isNullOrNil(paramContext)) {
        break label309;
      }
    }
    label309:
    for (paramContext = String.format("name:%s|latlng:%f,%f", new Object[] { paramContext, Double.valueOf(paramLocationInfo1.uZr), Double.valueOf(paramLocationInfo1.uZs) });; paramContext = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo1.uZr), Double.valueOf(paramLocationInfo1.uZs) }))
    {
      paramContext = String.format("intent://map/direction?origin=%s&destination=%s&mode=driving&coord_type=gcj02", new Object[] { paramLocationInfo2, paramContext });
      ad.d("MicroMsg.MapHelper", "url ".concat(String.valueOf(paramContext)));
      try
      {
        paramContext = paramContext + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
        ad.d("MicroMsg.MapHelper", "all: ".concat(String.valueOf(paramContext)));
        paramContext = Intent.getIntent(paramContext);
        AppMethodBeat.o(55818);
        return paramContext;
      }
      catch (URISyntaxException paramContext)
      {
        ad.printErrStackTrace("MicroMsg.MapHelper", paramContext, "", new Object[0]);
        AppMethodBeat.o(55818);
      }
      paramLocationInfo2 = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.uZr), Double.valueOf(paramLocationInfo2.uZs) });
      break;
    }
    return null;
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(55821);
    if ((paramBoolean) || (!paramLocationInfo2.dfX()))
    {
      paramContext = e.b(new double[] { paramLocationInfo1.uZs, paramLocationInfo1.uZr });
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramContext[1]), Double.valueOf(paramContext[0]), Integer.valueOf(paramLocationInfo1.uZt) })));
      paramContext.setPackage(paramString);
      AppMethodBeat.o(55821);
      return paramContext;
    }
    String str2 = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.uZr), Double.valueOf(paramLocationInfo2.uZs), Double.valueOf(paramLocationInfo1.uZr), Double.valueOf(paramLocationInfo1.uZs) });
    String str1 = str2;
    if (!bt.isNullOrNil(paramLocationInfo2.uZu))
    {
      str1 = str2;
      if (!bt.isNullOrNil(paramLocationInfo1.uZu)) {
        str1 = str2 + String.format("&from=%s&to=%s", new Object[] { paramLocationInfo2.uZu, paramLocationInfo1.uZu });
      }
    }
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    paramLocationInfo2.setPackage(paramString);
    if (bt.aj(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(55821);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.uZr + "," + paramLocationInfo1.uZs));
    paramContext.setPackage(paramString);
    AppMethodBeat.o(55821);
    return paramContext;
  }
  
  private static Intent a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(55819);
    if ((paramBoolean) || (!paramLocationInfo2.dfX()))
    {
      paramLocationInfo2 = e.b(new double[] { paramLocationInfo1.uZs, paramLocationInfo1.uZr });
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramLocationInfo2[1]), Double.valueOf(paramLocationInfo2[0]), Integer.valueOf(paramLocationInfo1.uZt) })));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      AppMethodBeat.o(55819);
      return paramLocationInfo1;
    }
    if (bt.isNullOrNil(paramLocationInfo1.uZv)) {}
    for (String str = "zh-cn";; str = paramLocationInfo1.uZv)
    {
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(str)), new Object[] { Double.valueOf(paramLocationInfo2.uZr), Double.valueOf(paramLocationInfo2.uZs), Double.valueOf(paramLocationInfo1.uZr), Double.valueOf(paramLocationInfo1.uZs) })));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      AppMethodBeat.o(55819);
      return paramLocationInfo1;
    }
  }
  
  private static String a(Context paramContext, LocationInfo paramLocationInfo)
  {
    AppMethodBeat.i(55817);
    paramContext = paramContext.getString(2131760712);
    if ((!bt.isNullOrNil(paramLocationInfo.dDq)) && (!paramLocationInfo.dDq.equals(paramContext)))
    {
      paramContext = paramLocationInfo.dDq;
      AppMethodBeat.o(55817);
      return paramContext;
    }
    if (!bt.isNullOrNil(paramLocationInfo.uZu))
    {
      paramContext = paramLocationInfo.uZu;
      AppMethodBeat.o(55817);
      return paramContext;
    }
    AppMethodBeat.o(55817);
    return "";
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(55820);
    if ((paramBoolean) || (!paramLocationInfo2.dfX()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.uZr + "," + paramLocationInfo1.uZs + "?z=" + paramLocationInfo1.uZt));
      paramContext.setPackage("com.tencent.map");
      AppMethodBeat.o(55820);
      return paramContext;
    }
    String str2 = paramLocationInfo1.uZy;
    String str1 = str2;
    if (!bt.isNullOrNil(paramLocationInfo1.uZy))
    {
      str1 = str2;
      if (paramLocationInfo1.uZy.startsWith("qqmap_")) {
        str1 = paramLocationInfo1.uZy.substring(6);
      }
    }
    paramLocationInfo2 = a(paramContext, paramLocationInfo2);
    str2 = a(paramContext, paramLocationInfo1);
    paramLocationInfo2 = String.format("qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client", new Object[] { str1, Double.valueOf(paramLocationInfo1.uZr), Double.valueOf(paramLocationInfo1.uZs), URLEncoder.encode(paramLocationInfo2), URLEncoder.encode(str2) });
    ad.d("MicroMsg.MapHelper", "tencentluxian, url=%s", new Object[] { paramLocationInfo2 });
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(paramLocationInfo2));
    paramLocationInfo2.setPackage("com.tencent.map");
    if (bt.aj(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(55820);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.uZr + "," + paramLocationInfo1.uZs));
    paramContext.setPackage("com.tencent.map");
    AppMethodBeat.o(55820);
    return paramContext;
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(55822);
    if ((paramBoolean) || (!paramLocationInfo2.dfX()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.uZr + "," + paramLocationInfo1.uZs + "?z=" + paramLocationInfo1.uZt));
      paramContext.setPackage(paramString);
      AppMethodBeat.o(55822);
      return paramContext;
    }
    String str2 = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.uZr), Double.valueOf(paramLocationInfo2.uZs), Double.valueOf(paramLocationInfo1.uZr), Double.valueOf(paramLocationInfo1.uZs) });
    String str1 = str2;
    if (!bt.isNullOrNil(paramLocationInfo2.uZu))
    {
      str1 = str2;
      if (!bt.isNullOrNil(paramLocationInfo1.uZu)) {
        str1 = str2 + String.format("&from=%s&to=%s", new Object[] { paramLocationInfo2.uZu, paramLocationInfo1.uZu });
      }
    }
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    paramLocationInfo2.setPackage(paramString);
    if (bt.aj(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(55822);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.uZr + "," + paramLocationInfo1.uZs));
    paramContext.setPackage(paramString);
    AppMethodBeat.o(55822);
    return paramContext;
  }
  
  public static int dgu()
  {
    AppMethodBeat.i(55815);
    ad.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
    AppMethodBeat.o(55815);
    return 15;
  }
  
  public final void a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55823);
    PackageManager localPackageManager;
    if ("com.tencent.map".equals(paramString)) {
      if (paramBoolean)
      {
        g.yhR.f(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
        localPackageManager = this.context.getPackageManager();
        if (!"com.google.android.apps.maps".equals(paramString)) {
          break label307;
        }
        paramString = a(paramLocationInfo1, paramLocationInfo2, false);
        if (bt.aj(this.context, paramString)) {
          break label1077;
        }
      }
    }
    label307:
    label1077:
    for (paramLocationInfo1 = a(paramLocationInfo1, paramLocationInfo2, true);; paramLocationInfo1 = paramString)
    {
      g.yhR.f(10997, new Object[] { "4", "", Integer.valueOf(0), Integer.valueOf(0) });
      paramLocationInfo2 = this.context;
      paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramLocationInfo1);
      com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, paramLocationInfo1.ahp(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramLocationInfo2.startActivity((Intent)paramLocationInfo1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(55823);
      return;
      g.yhR.f(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
      break;
      if (paramBoolean)
      {
        g.yhR.f(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
        break;
      }
      g.yhR.f(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      break;
      if ("com.baidu.BaiduMap".equals(paramString))
      {
        paramString = a(this.context, paramLocationInfo1, paramLocationInfo2, false);
        if (bt.aj(this.context, paramString)) {
          break label1072;
        }
      }
      for (paramLocationInfo1 = a(this.context, paramLocationInfo1, paramLocationInfo2, true);; paramLocationInfo1 = paramString)
      {
        paramLocationInfo2 = e.aR(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(localPackageManager).toString();
        g.yhR.f(10997, new Object[] { "5", paramLocationInfo2, Integer.valueOf(0), Integer.valueOf(0) });
        paramLocationInfo2 = this.context;
        paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramLocationInfo1);
        com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, paramLocationInfo1.ahp(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramLocationInfo2.startActivity((Intent)paramLocationInfo1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(55823);
        return;
        if ("com.tencent.map".equals(paramString))
        {
          paramString = b(this.context, paramLocationInfo1, paramLocationInfo2, false);
          if (bt.aj(this.context, paramString)) {
            break label1067;
          }
        }
        for (paramLocationInfo1 = b(this.context, paramLocationInfo1, paramLocationInfo2, true);; paramLocationInfo1 = paramString)
        {
          g.yhR.f(10997, new Object[] { "2", "", Integer.valueOf(0), Integer.valueOf(0) });
          paramLocationInfo2 = this.context;
          paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramLocationInfo1);
          com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, paramLocationInfo1.ahp(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramLocationInfo2.startActivity((Intent)paramLocationInfo1.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(55823);
          return;
          PackageInfo localPackageInfo;
          Intent localIntent;
          if ("com.autonavi.minimap".equals(paramString))
          {
            localPackageInfo = e.aR(this.context, paramString);
            if (localPackageInfo != null)
            {
              localIntent = a(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
              if (bt.aj(this.context, localIntent)) {
                break label1061;
              }
            }
          }
          for (paramLocationInfo1 = a(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);; paramLocationInfo1 = localIntent)
          {
            paramLocationInfo2 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
            g.yhR.f(10997, new Object[] { "5", paramLocationInfo2, Integer.valueOf(0), Integer.valueOf(0) });
            paramLocationInfo2 = this.context;
            paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramLocationInfo1);
            com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, paramLocationInfo1.ahp(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramLocationInfo2.startActivity((Intent)paramLocationInfo1.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(55823);
            return;
            if ("com.sogou.map.android.maps".equals(paramString))
            {
              localPackageInfo = e.aR(this.context, paramString);
              if (localPackageInfo != null)
              {
                localIntent = b(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
                if (bt.aj(this.context, localIntent)) {
                  break label1055;
                }
              }
            }
            for (paramLocationInfo1 = b(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);; paramLocationInfo1 = localIntent)
            {
              paramLocationInfo2 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
              g.yhR.f(10997, new Object[] { "5", paramLocationInfo2, Integer.valueOf(0), Integer.valueOf(0) });
              paramLocationInfo2 = this.context;
              paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramLocationInfo1);
              com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, paramLocationInfo1.ahp(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramLocationInfo2.startActivity((Intent)paramLocationInfo1.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(55823);
              return;
            }
          }
        }
      }
    }
  }
  
  public final Map<String, String> b(LocationInfo paramLocationInfo)
  {
    AppMethodBeat.i(55824);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.tencent.map");
    localArrayList.add("com.google.android.apps.maps");
    localArrayList.add("com.baidu.BaiduMap");
    localArrayList.add("com.autonavi.minimap");
    localArrayList.add("com.sogou.map.android.maps");
    Object localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(paramLocationInfo.uZr), Double.valueOf(paramLocationInfo.uZs) })));
    Object localObject2 = this.context.getPackageManager();
    paramLocationInfo = new HashMap();
    localObject1 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 65536).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if (localArrayList.contains(((ResolveInfo)localObject2).activityInfo.packageName)) {
        paramLocationInfo.put(((ResolveInfo)localObject2).activityInfo.packageName, ((ResolveInfo)localObject2).activityInfo.loadLabel(this.context.getPackageManager()).toString());
      }
    }
    AppMethodBeat.o(55824);
    return paramLocationInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.d
 * JD-Core Version:    0.7.0.1
 */