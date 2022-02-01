package com.tencent.mm.plugin.lite;

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
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.plugin.lite.debug.a.1;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.logic.d;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.s;
import org.json.JSONException;

public final class c
  extends LiteAppCenter
  implements LiteAppCenter.IWxaLiteAppCallback
{
  public static final List<String> JZa;
  public static boolean baY;
  
  static
  {
    AppMethodBeat.i(271366);
    JZa = Arrays.asList(new String[] { "wxalitecce81f5fba338df4dd5f74df8229c600", "wxalitea95723728764364c6f996b4bdab3af52" });
    baY = false;
    k.load("mmv8");
    k.load("flutter");
    k.load("wechatlv");
    AppMethodBeat.o(271366);
  }
  
  public static void init()
  {
    AppMethodBeat.i(271356);
    setWxaLiteAppCallback(new c());
    baY = true;
    AppMethodBeat.o(271356);
  }
  
  public static boolean isInitialized()
  {
    return baY;
  }
  
  public final void dataReporting(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271467);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(271467);
      return;
    }
    paramString2 = paramString2.replaceAll(",", ";");
    reportKv(23449, paramString1 + "," + paramString2);
    AppMethodBeat.o(271467);
  }
  
  public final String[] getAppInfo(String paramString)
  {
    return new String[0];
  }
  
  public final LiteAppCenter.HostInfo getHostInfo()
  {
    AppMethodBeat.i(271397);
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
      AppMethodBeat.o(271397);
      return localHostInfo;
    }
  }
  
  public final WxaLiteAppBaselibInfo getLiteAppBaselibInfo(String paramString)
  {
    AppMethodBeat.i(271471);
    d.fUi();
    paramString = d.getLiteAppBaselibInfo(paramString);
    AppMethodBeat.o(271471);
    return paramString;
  }
  
  public final String getLiteAppRoot()
  {
    return at.acHs;
  }
  
  public final String getOfflineResource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(271428);
    Object localObject1 = d.fUi();
    if (!((d)localObject1).KaY.isEmpty())
    {
      localObject1 = ((d)localObject1).KaY.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Bundle localBundle = new Bundle();
        localBundle.putString("appId", paramString1);
        localBundle.putString("tag", paramString2);
        localBundle.putString("url", paramString3);
        localObject2 = (Bundle)j.a((String)((Map.Entry)localObject2).getKey(), localBundle, ((m)((Map.Entry)localObject2).getValue()).getClass());
        if ((localObject2 != null) && (!Util.isNullOrNil(((Bundle)localObject2).getString("result"))))
        {
          paramString1 = ((Bundle)localObject2).getString("result");
          AppMethodBeat.o(271428);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(271428);
    return null;
  }
  
  public final LiteAppCenter.SystemInfo getSystemInfo()
  {
    AppMethodBeat.i(271406);
    LiteAppCenter.SystemInfo localSystemInfo = new LiteAppCenter.SystemInfo();
    Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(localContext)) {
      localSystemInfo.networkType = "none";
    }
    for (;;)
    {
      float f = localContext.getResources().getDisplayMetrics().density;
      localSystemInfo.brand = Build.MANUFACTURER;
      localSystemInfo.model = q.aPo();
      localSystemInfo.language = LocaleUtil.getCurrentLanguage(localContext);
      localSystemInfo.platform = "Android";
      localSystemInfo.system = ("Android" + Build.VERSION.RELEASE);
      localSystemInfo.version = BuildInfo.CLIENT_VERSION;
      localSystemInfo.pixelRatio = f;
      localSystemInfo.navigationBarHeight = (bf.bk(localContext) / f);
      localSystemInfo.statusBarHeight = (bf.be(localContext) / f);
      localSystemInfo.titleBarHeight = (bf.fs(localContext) / f);
      localSystemInfo.darkMode = aw.isDarkMode();
      AppMethodBeat.o(271406);
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
    AppMethodBeat.i(271387);
    String str = g.getMessageDigest(String.valueOf(com.tencent.mm.kernel.b.aZt()).getBytes());
    AppMethodBeat.o(271387);
    return str;
  }
  
  public final String getUserAgent()
  {
    int i = 0;
    AppMethodBeat.i(271419);
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
          localObject3 = com.tencent.liteapp.b.efD;
          localObject3 = b.a.getAppContext().getPackageManager();
          localObject4 = com.tencent.liteapp.b.efD;
          localObject4 = com.tencent.liteapp.b.anE();
          if (localObject4 == null) {
            s.bIx("packageName");
          }
          localObject3 = ((PackageManager)localObject3).getPackageInfo((String)localObject4, 0);
          localObject4 = ((PackageInfo)localObject3).versionName;
          i = ((PackageInfo)localObject3).versionCode;
          String str2 = Build.VERSION.RELEASE;
          String str3 = q.aPo();
          String str4 = Build.ID;
          String str5 = BuildInfo.CLIENT_VERSION;
          String str6 = LocaleUtil.getApplicationLanguage();
          if (BuildInfo.IS_ARM64)
          {
            localObject3 = "arm64";
            localObject1 = String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045140 Mobile Safari/537.36 MMWEBID/3371 MicroMessenger/%s.%d(%s) Process/lite NetType/%s Language/%s ABI/%s WeChat/%s", new Object[] { str2, str3, str4, localObject4, Integer.valueOf(i), str5, localObject1, str6, localObject2, localObject3 });
            Log.i("MicroMsg.MMWxaLiteAppCenter", "get user agent:".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(271419);
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
        AppMethodBeat.o(271419);
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
    AppMethodBeat.i(271450);
    com.tencent.wxa.b.b localb = com.tencent.wxa.c.keQ().aidu;
    if ((localb != null) && ((localb.getActivity() instanceof com.tencent.liteapp.ui.a))) {
      ((com.tencent.liteapp.ui.a)localb.getActivity()).hideKeyboard();
    }
    AppMethodBeat.o(271450);
  }
  
  public final void onStoreSendResult(String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public final void onStoreSetData(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public final void openPage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(271379);
    try
    {
      Object localObject = new i(paramString4);
      if (((i)localObject).has("transparent"))
      {
        bool = ((i)localObject).getBoolean("transparent");
        d.fUi();
        localObject = d.et(paramString1);
        if (localObject != null) {
          break label119;
        }
        Log.e("MicroMsg.MMWxaLiteAppCenter", "openPage fail. appId:%s, path:%s query:%s, config:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
        AppMethodBeat.o(271379);
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
      paramString1.egI = localJSONException.egI;
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
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString2);
      com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aYi(), "com/tencent/mm/plugin/lite/MMWxaLiteAppCenter", "openPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)paramString2.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/plugin/lite/MMWxaLiteAppCenter", "openPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(271379);
    }
  }
  
  public final void reloadDebug(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271455);
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramString1);
    localBundle.putString("qr_url_query_string", paramString2);
    j.a(MMApplicationContext.getPackageName(), localBundle, com.tencent.mm.plugin.lite.debug.b.class, new a.1());
    AppMethodBeat.o(271455);
  }
  
  public final void reportIdKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(271441);
    h.OAn.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(271441);
  }
  
  public final void reportKv(int paramInt, String paramString)
  {
    AppMethodBeat.i(271433);
    h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(271433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c
 * JD-Core Version:    0.7.0.1
 */