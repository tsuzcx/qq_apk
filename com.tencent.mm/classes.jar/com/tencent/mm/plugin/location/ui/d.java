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
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  public int Ked;
  public int Kee;
  public boolean Kef;
  public Context context;
  public int hYb;
  private ActivityManager zXp;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(55816);
    this.Ked = 0;
    this.Kee = 0;
    this.hYb = -1;
    this.Kef = false;
    this.context = paramContext;
    this.zXp = ((ActivityManager)paramContext.getSystemService("activity"));
    AppMethodBeat.o(55816);
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(55818);
    if ((paramBoolean) || (!paramLocationInfo2.fUs()))
    {
      paramContext = e.c(new double[] { paramLocationInfo1.KbX, paramLocationInfo1.KbW });
      if (paramContext.length < 2) {}
      for (paramContext = Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX), Integer.valueOf(paramLocationInfo1.KbY) }));; paramContext = Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramContext[1]), Double.valueOf(paramContext[0]), Integer.valueOf(paramLocationInfo1.KbY) })))
      {
        paramContext = new Intent("android.intent.action.VIEW", paramContext);
        paramContext.setPackage("com.baidu.BaiduMap");
        AppMethodBeat.o(55818);
        return paramContext;
      }
    }
    String str = a(paramContext, paramLocationInfo2);
    if (!Util.isNullOrNil(str))
    {
      paramLocationInfo2 = String.format("name:%s|latlng:%f,%f", new Object[] { str, Double.valueOf(paramLocationInfo2.KbW), Double.valueOf(paramLocationInfo2.KbX) });
      paramContext = a(paramContext, paramLocationInfo1);
      if (Util.isNullOrNil(paramContext)) {
        break label363;
      }
    }
    label363:
    for (paramContext = String.format("name:%s|latlng:%f,%f", new Object[] { paramContext, Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX) });; paramContext = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX) }))
    {
      paramContext = String.format("intent://map/direction?origin=%s&destination=%s&mode=recommend&coord_type=gcj02", new Object[] { paramLocationInfo2, paramContext });
      Log.d("MicroMsg.MapHelper", "url ".concat(String.valueOf(paramContext)));
      try
      {
        paramContext = paramContext + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
        Log.d("MicroMsg.MapHelper", "all: ".concat(String.valueOf(paramContext)));
        paramContext = Intent.getIntent(paramContext);
        AppMethodBeat.o(55818);
        return paramContext;
      }
      catch (URISyntaxException paramContext)
      {
        Log.printErrStackTrace("MicroMsg.MapHelper", paramContext, "", new Object[0]);
        AppMethodBeat.o(55818);
      }
      paramLocationInfo2 = String.format("%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.KbW), Double.valueOf(paramLocationInfo2.KbX) });
      break;
    }
    return null;
  }
  
  private static Intent a(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(55821);
    if ((paramBoolean) || (!paramLocationInfo2.fUs()))
    {
      paramContext = e.c(new double[] { paramLocationInfo1.KbX, paramLocationInfo1.KbW });
      if (paramContext.length < 2) {}
      for (paramContext = Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX), Integer.valueOf(paramLocationInfo1.KbY) }));; paramContext = Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramContext[1]), Double.valueOf(paramContext[0]), Integer.valueOf(paramLocationInfo1.KbY) })))
      {
        paramContext = new Intent("android.intent.action.VIEW", paramContext);
        paramContext.setPackage(paramString);
        AppMethodBeat.o(55821);
        return paramContext;
      }
    }
    String str = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.KbW), Double.valueOf(paramLocationInfo2.KbX), Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX) });
    Object localObject = str;
    if (!Util.isNullOrNil(paramLocationInfo2.KbZ)) {
      if (Util.isNullOrNil(paramLocationInfo1.KbZ))
      {
        localObject = str;
        if (Util.isNullOrNil(paramLocationInfo1.hVI)) {}
      }
      else
      {
        localObject = new StringBuilder().append(str);
        str = paramLocationInfo2.KbZ;
        if (Util.isNullOrNil(paramLocationInfo1.hVI)) {
          break label344;
        }
      }
    }
    label344:
    for (paramLocationInfo2 = paramLocationInfo1.hVI;; paramLocationInfo2 = paramLocationInfo1.KbZ)
    {
      localObject = String.format("&from=%s&to=%s", new Object[] { str, paramLocationInfo2 });
      paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      paramLocationInfo2.setPackage(paramString);
      if (!Util.isIntentAvailable(paramContext, paramLocationInfo2)) {
        break;
      }
      AppMethodBeat.o(55821);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.KbW + "," + paramLocationInfo1.KbX));
    paramContext.setPackage(paramString);
    AppMethodBeat.o(55821);
    return paramContext;
  }
  
  private static Intent a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(55819);
    if ((paramBoolean) || (!paramLocationInfo2.fUs()))
    {
      paramLocationInfo2 = e.c(new double[] { paramLocationInfo1.KbX, paramLocationInfo1.KbW });
      if (paramLocationInfo2.length < 2) {}
      for (paramLocationInfo1 = Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX), Integer.valueOf(paramLocationInfo1.KbY) }));; paramLocationInfo1 = Uri.parse(String.format("geo:%s,%s?z=%s", new Object[] { Double.valueOf(paramLocationInfo2[1]), Double.valueOf(paramLocationInfo2[0]), Integer.valueOf(paramLocationInfo1.KbY) })))
      {
        paramLocationInfo1 = new Intent("android.intent.action.VIEW", paramLocationInfo1);
        paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        AppMethodBeat.o(55819);
        return paramLocationInfo1;
      }
    }
    if (Util.isNullOrNil(paramLocationInfo1.Kca)) {}
    for (String str = "zh-cn";; str = paramLocationInfo1.Kca)
    {
      paramLocationInfo1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(str)), new Object[] { Double.valueOf(paramLocationInfo2.KbW), Double.valueOf(paramLocationInfo2.KbX), Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX) })));
      paramLocationInfo1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      AppMethodBeat.o(55819);
      return paramLocationInfo1;
    }
  }
  
  private static String a(Context paramContext, LocationInfo paramLocationInfo)
  {
    AppMethodBeat.i(55817);
    paramContext = paramContext.getString(a.i.location_conversation);
    if ((!Util.isNullOrNil(paramLocationInfo.hVI)) && (!paramLocationInfo.hVI.equals(paramContext)))
    {
      paramContext = paramLocationInfo.hVI;
      AppMethodBeat.o(55817);
      return paramContext;
    }
    if (!Util.isNullOrNil(paramLocationInfo.KbZ))
    {
      paramContext = paramLocationInfo.KbZ;
      AppMethodBeat.o(55817);
      return paramContext;
    }
    AppMethodBeat.o(55817);
    return "";
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean)
  {
    AppMethodBeat.i(55820);
    if ((paramBoolean) || (!paramLocationInfo2.fUs()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.KbW + "," + paramLocationInfo1.KbX + "?z=" + paramLocationInfo1.KbY));
      paramContext.setPackage("com.tencent.map");
      AppMethodBeat.o(55820);
      return paramContext;
    }
    String str2 = paramLocationInfo1.Kcd;
    String str1 = str2;
    if (!Util.isNullOrNil(paramLocationInfo1.Kcd))
    {
      str1 = str2;
      if (paramLocationInfo1.Kcd.startsWith("qqmap_")) {
        str1 = paramLocationInfo1.Kcd.substring(6);
      }
    }
    paramLocationInfo2 = a(paramContext, paramLocationInfo2);
    str2 = a(paramContext, paramLocationInfo1);
    paramLocationInfo2 = String.format("qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client", new Object[] { str1, Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX), URLEncoder.encode(paramLocationInfo2), URLEncoder.encode(str2) });
    Log.d("MicroMsg.MapHelper", "tencentluxian, url=%s", new Object[] { paramLocationInfo2 });
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(paramLocationInfo2));
    paramLocationInfo2.setPackage("com.tencent.map");
    if (Util.isIntentAvailable(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(55820);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.KbW + "," + paramLocationInfo1.KbX));
    paramContext.setPackage("com.tencent.map");
    AppMethodBeat.o(55820);
    return paramContext;
  }
  
  private static Intent b(Context paramContext, LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(55822);
    if ((paramBoolean) || (!paramLocationInfo2.fUs()))
    {
      paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.KbW + "," + paramLocationInfo1.KbX + "?z=" + paramLocationInfo1.KbY));
      paramContext.setPackage(paramString);
      AppMethodBeat.o(55822);
      return paramContext;
    }
    String str2 = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[] { Double.valueOf(paramLocationInfo2.KbW), Double.valueOf(paramLocationInfo2.KbX), Double.valueOf(paramLocationInfo1.KbW), Double.valueOf(paramLocationInfo1.KbX) });
    String str1 = str2;
    if (!Util.isNullOrNil(paramLocationInfo2.KbZ))
    {
      str1 = str2;
      if (!Util.isNullOrNil(paramLocationInfo1.KbZ)) {
        str1 = str2 + String.format("&from=%s&to=%s", new Object[] { paramLocationInfo2.KbZ, paramLocationInfo1.KbZ });
      }
    }
    paramLocationInfo2 = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    paramLocationInfo2.setPackage(paramString);
    if (Util.isIntentAvailable(paramContext, paramLocationInfo2))
    {
      AppMethodBeat.o(55822);
      return paramLocationInfo2;
    }
    paramContext = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + paramLocationInfo1.KbW + "," + paramLocationInfo1.KbX));
    paramContext.setPackage(paramString);
    AppMethodBeat.o(55822);
    return paramContext;
  }
  
  public static int fUQ()
  {
    AppMethodBeat.i(55815);
    Log.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
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
        h.OAn.b(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
        localPackageManager = this.context.getPackageManager();
        if (!"com.google.android.apps.maps".equals(paramString)) {
          break label307;
        }
        paramString = a(paramLocationInfo1, paramLocationInfo2, false);
        if (Util.isIntentAvailable(this.context, paramString)) {
          break label1077;
        }
      }
    }
    label307:
    label1077:
    for (paramLocationInfo1 = a(paramLocationInfo1, paramLocationInfo2, true);; paramLocationInfo1 = paramString)
    {
      h.OAn.b(10997, new Object[] { "4", "", Integer.valueOf(0), Integer.valueOf(0) });
      paramLocationInfo2 = this.context;
      paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramLocationInfo1);
      com.tencent.mm.hellhoundlib.a.a.b(paramLocationInfo2, paramLocationInfo1.aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramLocationInfo2.startActivity((Intent)paramLocationInfo1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(55823);
      return;
      h.OAn.b(11091, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
      break;
      if (paramBoolean)
      {
        h.OAn.b(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
        break;
      }
      h.OAn.b(11091, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      break;
      if ("com.baidu.BaiduMap".equals(paramString))
      {
        paramString = a(this.context, paramLocationInfo1, paramLocationInfo2, false);
        if (Util.isIntentAvailable(this.context, paramString)) {
          break label1072;
        }
      }
      for (paramLocationInfo1 = a(this.context, paramLocationInfo1, paramLocationInfo2, true);; paramLocationInfo1 = paramString)
      {
        paramLocationInfo2 = e.bu(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(localPackageManager).toString();
        h.OAn.b(10997, new Object[] { "5", paramLocationInfo2, Integer.valueOf(0), Integer.valueOf(0) });
        paramLocationInfo2 = this.context;
        paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramLocationInfo1);
        com.tencent.mm.hellhoundlib.a.a.b(paramLocationInfo2, paramLocationInfo1.aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramLocationInfo2.startActivity((Intent)paramLocationInfo1.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(55823);
        return;
        if ("com.tencent.map".equals(paramString))
        {
          paramString = b(this.context, paramLocationInfo1, paramLocationInfo2, false);
          if (Util.isIntentAvailable(this.context, paramString)) {
            break label1067;
          }
        }
        for (paramLocationInfo1 = b(this.context, paramLocationInfo1, paramLocationInfo2, true);; paramLocationInfo1 = paramString)
        {
          h.OAn.b(10997, new Object[] { "2", "", Integer.valueOf(0), Integer.valueOf(0) });
          paramLocationInfo2 = this.context;
          paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramLocationInfo1);
          com.tencent.mm.hellhoundlib.a.a.b(paramLocationInfo2, paramLocationInfo1.aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramLocationInfo2.startActivity((Intent)paramLocationInfo1.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(55823);
          return;
          PackageInfo localPackageInfo;
          Intent localIntent;
          if ("com.autonavi.minimap".equals(paramString))
          {
            localPackageInfo = e.bu(this.context, paramString);
            if (localPackageInfo != null)
            {
              localIntent = a(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
              if (Util.isIntentAvailable(this.context, localIntent)) {
                break label1061;
              }
            }
          }
          for (paramLocationInfo1 = a(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);; paramLocationInfo1 = localIntent)
          {
            paramLocationInfo2 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
            h.OAn.b(10997, new Object[] { "5", paramLocationInfo2, Integer.valueOf(0), Integer.valueOf(0) });
            paramLocationInfo2 = this.context;
            paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramLocationInfo1);
            com.tencent.mm.hellhoundlib.a.a.b(paramLocationInfo2, paramLocationInfo1.aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramLocationInfo2.startActivity((Intent)paramLocationInfo1.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(55823);
            return;
            if ("com.sogou.map.android.maps".equals(paramString))
            {
              localPackageInfo = e.bu(this.context, paramString);
              if (localPackageInfo != null)
              {
                localIntent = b(this.context, paramLocationInfo1, paramLocationInfo2, false, paramString);
                if (Util.isIntentAvailable(this.context, localIntent)) {
                  break label1055;
                }
              }
            }
            for (paramLocationInfo1 = b(this.context, paramLocationInfo1, paramLocationInfo2, true, paramString);; paramLocationInfo1 = localIntent)
            {
              paramLocationInfo2 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
              h.OAn.b(10997, new Object[] { "5", paramLocationInfo2, Integer.valueOf(0), Integer.valueOf(0) });
              paramLocationInfo2 = this.context;
              paramLocationInfo1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramLocationInfo1);
              com.tencent.mm.hellhoundlib.a.a.b(paramLocationInfo2, paramLocationInfo1.aYi(), "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramLocationInfo2.startActivity((Intent)paramLocationInfo1.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramLocationInfo2, "com/tencent/mm/plugin/location/ui/MapHelper", "startNavigationActivity", "(Lcom/tencent/mm/plugin/location/model/LocationInfo;Lcom/tencent/mm/plugin/location/model/LocationInfo;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    Object localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(paramLocationInfo.KbW), Double.valueOf(paramLocationInfo.KbX) })));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.d
 * JD-Core Version:    0.7.0.1
 */