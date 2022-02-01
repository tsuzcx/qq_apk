package com.tencent.mm.plugin.lite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.liteapp.b.a;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.debug.a.1;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import org.json.JSONException;

public final class c
  extends LiteAppCenter
  implements LiteAppCenter.IWxaLiteAppCallback
{
  public static final List<String> EfI;
  private static int EfJ;
  private static HashMap<Integer, com.tencent.liteapp.jsapi.a> EfK;
  
  static
  {
    AppMethodBeat.i(233729);
    EfI = Arrays.asList(new String[] { "wxalitecce81f5fba338df4dd5f74df8229c600", "wxalitea95723728764364c6f996b4bdab3af52" });
    EfJ = 0;
    EfK = new HashMap();
    com.tencent.mm.compatible.util.j.load("mmv8");
    com.tencent.mm.compatible.util.j.load("flutter");
    com.tencent.mm.compatible.util.j.load("wechatlv");
    AppMethodBeat.o(233729);
  }
  
  public static int a(com.tencent.liteapp.jsapi.a parama)
  {
    AppMethodBeat.i(233705);
    EfJ += 1;
    EfK.put(Integer.valueOf(EfJ), parama);
    int i = EfJ;
    AppMethodBeat.o(233705);
    return i;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(233707);
    com.tencent.liteapp.jsapi.a locala = (com.tencent.liteapp.jsapi.a)EfK.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(233707);
      return;
    }
    locala.b(paramInt2, paramInt3, paramIntent);
    EfK.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(233707);
  }
  
  public static void init()
  {
    AppMethodBeat.i(233702);
    setWxaLiteAppCallback(new c());
    AppMethodBeat.o(233702);
  }
  
  public final void dataReporting(String paramString1, String paramString2) {}
  
  public final String[] getAppInfo(String paramString)
  {
    return new String[0];
  }
  
  public final LiteAppCenter.HostInfo getHostInfo()
  {
    AppMethodBeat.i(233718);
    LiteAppCenter.HostInfo localHostInfo = new LiteAppCenter.HostInfo();
    localHostInfo.system = "Android";
    localHostInfo.systemVersion = ("Android " + Build.VERSION.RELEASE);
    localHostInfo.appVersion = BuildInfo.CLIENT_VERSION;
    localHostInfo.appRevision = BuildInfo.REV;
    localHostInfo.appBranch = BuildInfo.BUILD_TAG;
    localHostInfo.appBuildJob = BuildInfo.HOSTNAME;
    localHostInfo.appBuildTime = BuildInfo.TIME;
    if (BuildInfo.IS_FLAVOR_RED) {}
    for (String str = "red";; str = "release")
    {
      localHostInfo.appFlavor = str;
      AppMethodBeat.o(233718);
      return localHostInfo;
    }
  }
  
  public final String getLiteAppRoot()
  {
    return com.tencent.mm.storage.ar.Vgd;
  }
  
  public final String getOfflineResource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(233723);
    Object localObject1 = f.eLH();
    if (!((f)localObject1).EgC.isEmpty())
    {
      localObject1 = ((f)localObject1).EgC.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Bundle localBundle = new Bundle();
        localBundle.putString("appId", paramString1);
        localBundle.putString("tag", paramString2);
        localBundle.putString("url", paramString3);
        localObject2 = (Bundle)com.tencent.mm.ipcinvoker.j.a((String)((Map.Entry)localObject2).getKey(), localBundle, ((m)((Map.Entry)localObject2).getValue()).getClass());
        if ((localObject2 != null) && (!Util.isNullOrNil(((Bundle)localObject2).getString("result"))))
        {
          paramString1 = ((Bundle)localObject2).getString("result");
          AppMethodBeat.o(233723);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(233723);
    return null;
  }
  
  public final LiteAppCenter.SystemInfo getSystemInfo()
  {
    AppMethodBeat.i(233719);
    LiteAppCenter.SystemInfo localSystemInfo = new LiteAppCenter.SystemInfo();
    Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(localContext)) {
      localSystemInfo.networkType = "none";
    }
    for (;;)
    {
      float f = localContext.getResources().getDisplayMetrics().density;
      localSystemInfo.brand = Build.MANUFACTURER;
      localSystemInfo.model = Build.MODEL;
      localSystemInfo.language = LocaleUtil.getCurrentLanguage(localContext);
      localSystemInfo.platform = "Android";
      localSystemInfo.system = ("Android" + Build.VERSION.RELEASE);
      localSystemInfo.version = BuildInfo.CLIENT_VERSION;
      localSystemInfo.pixelRatio = f;
      localSystemInfo.navigationBarHeight = (ax.aB(localContext) / f);
      localSystemInfo.statusBarHeight = (ax.at(localContext) / f);
      localSystemInfo.titleBarHeight = (ax.ew(localContext) / f);
      localSystemInfo.darkMode = com.tencent.mm.ui.ar.isDarkMode();
      AppMethodBeat.o(233719);
      return localSystemInfo;
      if (NetStatusUtil.is2G(localContext)) {
        localSystemInfo.networkType = "2g";
      } else if (NetStatusUtil.is3G(localContext)) {
        localSystemInfo.networkType = "3g";
      } else if (NetStatusUtil.is4G(localContext)) {
        localSystemInfo.networkType = "4g";
      } else if (NetStatusUtil.isWifi(localContext)) {
        localSystemInfo.networkType = "wifi";
      } else {
        localSystemInfo.networkType = "unknown";
      }
    }
  }
  
  public final String getUin()
  {
    AppMethodBeat.i(233715);
    int i = com.tencent.mm.kernel.b.aGr();
    String str = i & 0xFFFFFFFF;
    AppMethodBeat.o(233715);
    return str;
  }
  
  public final String getUserAgent()
  {
    int i = 0;
    AppMethodBeat.i(233722);
    Object localObject2 = "NoNet";
    for (;;)
    {
      try
      {
        Object localObject3 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
        Object localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
          localObject1 = localObject2;
          if (localObject3 == null) {}
        }
        switch (((NetworkInfo)localObject3).getType())
        {
        case 1: 
          localObject3 = "arm32";
          Object localObject4 = Build.SUPPORTED_ABIS;
          int j = localObject4.length;
          localObject2 = localObject3;
          if (i < j)
          {
            if (!"arm64-v8a".equals(localObject4[i])) {
              break;
            }
            localObject2 = "arm64";
          }
          localObject3 = com.tencent.liteapp.b.cox;
          localObject3 = b.a.getAppContext().getPackageManager();
          localObject4 = com.tencent.liteapp.b.cox;
          localObject4 = com.tencent.liteapp.b.Nl();
          if (localObject4 == null) {
            p.bGy("packageName");
          }
          localObject3 = ((PackageManager)localObject3).getPackageInfo((String)localObject4, 0);
          localObject4 = ((PackageInfo)localObject3).versionName;
          i = ((PackageInfo)localObject3).versionCode;
          String str2 = Build.VERSION.RELEASE;
          String str3 = Build.MODEL;
          String str4 = Build.ID;
          String str5 = BuildInfo.CLIENT_VERSION;
          String str6 = LocaleUtil.getApplicationLanguage();
          if (BuildInfo.IS_ARM64)
          {
            localObject3 = "arm64";
            localObject1 = String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045140 Mobile Safari/537.36 MMWEBID/3371 MicroMessenger/%s.%d(%s) Process/lite NetType/%s Language/%s ABI/%s WeChat/%s", new Object[] { str2, str3, str4, localObject4, Integer.valueOf(i), str5, localObject1, str6, localObject2, localObject3 });
            Log.i("MicroMsg.MMWxaLiteAppCenter", "get user agent:".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(233722);
            return localObject1;
            localObject1 = "WIFI";
            continue;
          }
          localObject3 = "arm32";
          break;
        default: 
          str1 = "OtherNet";
        }
      }
      catch (Exception localException)
      {
        str1 = System.getProperty("http.agent");
        AppMethodBeat.o(233722);
        return str1;
      }
      continue;
      String str1 = "4G";
      continue;
      i += 1;
    }
  }
  
  public final void hideKeyboard()
  {
    AppMethodBeat.i(233726);
    Activity localActivity = com.tencent.wxa.c.ivt().ZYK.getActivity();
    if ((localActivity instanceof com.tencent.liteapp.ui.a)) {
      ((com.tencent.liteapp.ui.a)localActivity).hideKeyboard();
    }
    AppMethodBeat.o(233726);
  }
  
  public final void openPage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(233713);
    try
    {
      Object localObject = new i(paramString4);
      if (((i)localObject).has("transparent"))
      {
        bool = ((i)localObject).getBoolean("transparent");
        f.eLH();
        localObject = f.cY(paramString1);
        if (localObject != null) {
          break label119;
        }
        Log.e("MicroMsg.MMWxaLiteAppCenter", "openPage fail. appId:%s, path:%s query:%s, config:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
        AppMethodBeat.o(233713);
      }
    }
    catch (JSONException localJSONException)
    {
      boolean bool;
      for (;;)
      {
        Log.e("MicroMsg.MMWxaLiteAppCenter", "openPage fail. %s", new Object[] { localJSONException.toString() });
        bool = false;
      }
      label119:
      paramString1 = new WxaLiteAppLaunchInfo();
      paramString1.setAppId(localJSONException.appId);
      paramString1.pkgPath = localJSONException.path;
      paramString1.coX = localJSONException.coX;
      paramString1.startTime = System.currentTimeMillis();
      paramString4 = new Bundle();
      paramString4.putString("path", paramString2);
      paramString4.putString("query", paramString3);
      if (bool) {
        paramString4.putBoolean("transparent", true);
      }
      paramString1.path = paramString4.getString("path");
      paramString1.query = paramString4.getString("query");
      paramString2 = new Intent();
      paramString2.addFlags(268435456);
      paramString2.setClass(MMApplicationContext.getContext(), WxaLiteAppProxyUI.class);
      paramString2.putExtra("WxaLiteAppLaunchInfo", paramString1);
      paramString2.putExtra("bundle", paramString4);
      paramString1 = MMApplicationContext.getContext();
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString2);
      com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aFh(), "com/tencent/mm/plugin/lite/MMWxaLiteAppCenter", "openPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)paramString2.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/plugin/lite/MMWxaLiteAppCenter", "openPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(233713);
    }
  }
  
  public final void reloadDebug(String paramString1, String paramString2)
  {
    AppMethodBeat.i(233728);
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramString1);
    localBundle.putString("qr_url_query_string", paramString2);
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), localBundle, com.tencent.mm.plugin.lite.debug.b.class, new a.1());
    AppMethodBeat.o(233728);
  }
  
  public final void reportIdKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(233725);
    h.IzE.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(233725);
  }
  
  public final void reportKv(int paramInt, String paramString)
  {
    AppMethodBeat.i(233724);
    h.IzE.kvStat(paramInt, paramString);
    AppMethodBeat.o(233724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c
 * JD-Core Version:    0.7.0.1
 */