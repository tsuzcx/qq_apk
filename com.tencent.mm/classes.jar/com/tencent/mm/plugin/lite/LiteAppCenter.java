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
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.lite.jsapi.a.3;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class LiteAppCenter
{
  public static final String LITE_APP_BASE_LIB = "wxalitebaselibrary";
  public static final String LITE_APP_GAME_CENTER = "wxalitecce81f5fba338df4dd5f74df8229c600";
  public static final String[] LITE_APP_PACKAGES;
  private static final String TAG = "MicroMsg.LiteAppCenter";
  private static ILiteAppCallback mCallback;
  private static HashMap<Long, ILiteAppUICallback> mUICallback;
  private static long pageId;
  private static HashMap<Long, PageInfo> pageInfos;
  private static Map<String, Map<String, Class<? extends com.tencent.mm.plugin.lite.jsapi.a>>> sAppLevelApi;
  private static Map<String, Class<? extends com.tencent.mm.plugin.lite.jsapi.a>> sCommApi;
  private static int selectConversationUICallbackId;
  private static HashMap<Integer, com.tencent.mm.plugin.lite.jsapi.a> selectConversationUICallbacks;
  private static HashMap<Long, SystemInfoChangeCallbackInfo> systemInfoChangeCallback;
  
  static
  {
    AppMethodBeat.i(212360);
    LITE_APP_PACKAGES = new String[] { "wxalitecce81f5fba338df4dd5f74df8229c600" };
    selectConversationUICallbackId = 0;
    selectConversationUICallbacks = new HashMap();
    systemInfoChangeCallback = new HashMap();
    pageInfos = new HashMap();
    pageId = -1L;
    com.tencent.mm.compatible.util.j.load("mmv8");
    com.tencent.mm.compatible.util.j.load("flutter");
    com.tencent.mm.compatible.util.j.load("wechatlv");
    sCommApi = new ConcurrentHashMap();
    sAppLevelApi = new ConcurrentHashMap();
    mUICallback = new HashMap();
    AppMethodBeat.o(212360);
  }
  
  private static native PageInfo _showIndexView(String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native PageInfo _showView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  private static native void addJsApi(String paramString);
  
  public static void addJsApi(String paramString, Class<? extends com.tencent.mm.plugin.lite.jsapi.a> paramClass)
  {
    AppMethodBeat.i(212326);
    if (sCommApi.containsKey(paramString))
    {
      paramString = new RuntimeException(paramString + " has been exists");
      AppMethodBeat.o(212326);
      throw paramString;
    }
    sCommApi.put(paramString, paramClass);
    addJsApi(paramString);
    AppMethodBeat.o(212326);
  }
  
  private static native void addJsApi(String paramString1, String paramString2);
  
  public static void addJsApi(String paramString1, String paramString2, Class<? extends com.tencent.mm.plugin.lite.jsapi.a> paramClass)
  {
    AppMethodBeat.i(212328);
    Map localMap = (Map)sAppLevelApi.get(paramString1);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      sAppLevelApi.put(paramString1, localObject);
    }
    if (((Map)localObject).containsKey(paramString2))
    {
      paramString1 = new RuntimeException(paramString1 + ":" + paramString2 + " has been exists");
      AppMethodBeat.o(212328);
      throw paramString1;
    }
    ((Map)localObject).put(paramString2, paramClass);
    addJsApi(paramString1, paramString2);
    AppMethodBeat.o(212328);
  }
  
  public static void addJsApi(String paramString, Map<String, Class> paramMap)
  {
    AppMethodBeat.i(212329);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!com.tencent.mm.plugin.lite.jsapi.a.class.isAssignableFrom((Class)localEntry.getValue()))
      {
        paramString = new RuntimeException(paramString + ":api must be subclass of LiteAppJsApi");
        AppMethodBeat.o(212329);
        throw paramString;
      }
      addJsApi(paramString, (String)localEntry.getKey(), (Class)localEntry.getValue());
    }
    AppMethodBeat.o(212329);
  }
  
  public static void addJsApi(Map<String, Class> paramMap)
  {
    AppMethodBeat.i(212327);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!com.tencent.mm.plugin.lite.jsapi.a.class.isAssignableFrom((Class)localEntry.getValue()))
      {
        paramMap = new RuntimeException("api must be subclass of LiteAppJsApi");
        AppMethodBeat.o(212327);
        throw paramMap;
      }
      addJsApi((String)localEntry.getKey(), (Class)localEntry.getValue());
    }
    AppMethodBeat.o(212327);
  }
  
  public static int addSelectConversationUICallback(com.tencent.mm.plugin.lite.jsapi.a parama)
  {
    AppMethodBeat.i(212331);
    selectConversationUICallbackId += 1;
    selectConversationUICallbacks.put(Integer.valueOf(selectConversationUICallbackId), parama);
    int i = selectConversationUICallbackId;
    AppMethodBeat.o(212331);
    return i;
  }
  
  private static String getAppFilePath()
  {
    return am.IKj;
  }
  
  private static boolean getAppInfo(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(212349);
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 2))
    {
      ae.e("MicroMsg.LiteAppCenter", "info invalid");
      AppMethodBeat.o(212349);
      return false;
    }
    if (mCallback != null)
    {
      paramString = mCallback.getAppInfo(paramString);
      if ((paramString == null) || (paramString.length != paramArrayOfString.length))
      {
        AppMethodBeat.o(212349);
        return false;
      }
      paramArrayOfString[0] = paramString[0];
      paramArrayOfString[1] = paramString[1];
    }
    AppMethodBeat.o(212349);
    return false;
  }
  
  public static native String getAuthUrl(String paramString1, String paramString2, String paramString3);
  
  public static native String getBaseLibBuildTypeByPath(String paramString);
  
  public static native String getBaseLibBuildTypeByString(String paramString);
  
  public static native String getBaseLibVersionByPath(String paramString);
  
  public static native String getBaseLibVersionByString(String paramString);
  
  public static native String getLiteAppVersion(String paramString1, String paramString2, String paramString3);
  
  private static String getSystemInfo()
  {
    AppMethodBeat.i(212352);
    Object localObject = new JSONObject();
    for (;;)
    {
      Context localContext;
      try
      {
        localContext = ak.getContext();
        if (!az.isConnected(localContext))
        {
          ((JSONObject)localObject).put("networkType", "none");
          ((JSONObject)localObject).put("brand", Build.MANUFACTURER);
          ((JSONObject)localObject).put("model", Build.MODEL);
          ((JSONObject)localObject).put("language", ad.iR(localContext));
          ((JSONObject)localObject).put("platform", "Android");
          ((JSONObject)localObject).put("system", "Android " + Build.VERSION.RELEASE);
          ((JSONObject)localObject).put("version", com.tencent.mm.sdk.platformtools.j.hju);
          float f = localContext.getResources().getDisplayMetrics().density;
          ((JSONObject)localObject).put("pixelRatio", f);
          ((JSONObject)localObject).put("navigationBarHeight", ar.en(localContext) / f);
          ((JSONObject)localObject).put("statusBarHeight", ar.kd(localContext) / f);
          ((JSONObject)localObject).put("titleBarHeight", ar.dX(localContext) / f);
          ((JSONObject)localObject).put("darkMode", al.isDarkMode());
          localObject = ((JSONObject)localObject).toString();
          AppMethodBeat.o(212352);
          return localObject;
        }
        if (az.is2G(localContext))
        {
          ((JSONObject)localObject).put("networkType", "2g");
          continue;
        }
        if (!az.is3G(localContext)) {
          break label262;
        }
      }
      catch (JSONException localJSONException)
      {
        AppMethodBeat.o(212352);
        return "";
      }
      localJSONException.put("networkType", "3g");
      continue;
      label262:
      if (az.is4G(localContext)) {
        localJSONException.put("networkType", "4g");
      } else if (az.isWifi(localContext)) {
        localJSONException.put("networkType", "wifi");
      } else {
        localJSONException.put("networkType", "unknown");
      }
    }
  }
  
  private static String getUin()
  {
    AppMethodBeat.i(212357);
    int i = com.tencent.mm.kernel.a.aiG();
    String str = i & 0xFFFFFFFF;
    AppMethodBeat.o(212357);
    return str;
  }
  
  private static String getUserAgent()
  {
    int i = 0;
    AppMethodBeat.i(212356);
    Object localObject2 = "NoNet";
    for (;;)
    {
      try
      {
        Object localObject3 = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
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
          localObject3 = ak.getContext().getPackageManager().getPackageInfo(ak.getPackageName(), 0);
          localObject4 = ((PackageInfo)localObject3).versionName;
          i = ((PackageInfo)localObject3).versionCode;
          String str2 = Build.VERSION.RELEASE;
          String str3 = Build.MODEL;
          String str4 = Build.ID;
          String str5 = com.tencent.mm.sdk.platformtools.j.hju;
          String str6 = ad.fom();
          if (com.tencent.mm.sdk.platformtools.j.hjx)
          {
            localObject3 = "arm64";
            localObject1 = String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045140 Mobile Safari/537.36 MMWEBID/3371 MicroMessenger/%s.%d(%s) Process/lite NetType/%s Language/%s ABI/%s WeChat/%s", new Object[] { str2, str3, str4, localObject4, Integer.valueOf(i), str5, localObject1, str6, localObject2, localObject3 });
            ae.i("MicroMsg.LiteAppCenter", "get user agent:".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(212356);
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
        AppMethodBeat.o(212356);
        return str1;
      }
      continue;
      String str1 = "4G";
      continue;
      i += 1;
    }
  }
  
  private static boolean hasCutOut(long paramLong)
  {
    AppMethodBeat.i(212355);
    if (mUICallback.containsKey(Long.valueOf(paramLong)))
    {
      boolean bool = ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).hasCutOut();
      AppMethodBeat.o(212355);
      return bool;
    }
    AppMethodBeat.o(212355);
    return false;
  }
  
  private static void invokeJsApi(JsApi paramJsApi)
  {
    AppMethodBeat.i(212341);
    ae.i("MicroMsg.LiteAppCenter", "invokeJsApi:".concat(String.valueOf(paramJsApi)));
    label460:
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        if (paramJsApi.appId == null)
        {
          ae.e("MicroMsg.LiteAppCenter", "invalid api ".concat(String.valueOf(paramJsApi)));
          AppMethodBeat.o(212341);
          return;
        }
        if ((paramJsApi.method == null) || (paramJsApi.param == null))
        {
          ae.e("MicroMsg.LiteAppCenter", "invalid api ".concat(String.valueOf(paramJsApi)));
          if (paramJsApi.callbackId > 0L) {
            jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg: \"invalid api\", data: {}}", false);
          }
          AppMethodBeat.o(212341);
          return;
        }
        Object localObject1 = null;
        if (sAppLevelApi.containsKey(paramJsApi.appId)) {
          localObject1 = (Class)((Map)sAppLevelApi.get(paramJsApi.appId)).get(paramJsApi.method);
        }
        if (localObject1 != null) {
          break label460;
        }
        localObject1 = (Class)sCommApi.get(paramJsApi.method);
        if (localObject1 == null)
        {
          ae.e("MicroMsg.LiteAppCenter", "not found api ".concat(String.valueOf(paramJsApi)));
          if (paramJsApi.callbackId > 0L) {
            jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg:\"not found\" ,data: {}}", false);
          }
          AppMethodBeat.o(212341);
          return;
        }
        localObject2 = new b(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId);
        localObject1 = (com.tencent.mm.plugin.lite.jsapi.a)((Class)localObject1).getConstructor(new Class[0]).newInstance(new Object[0]);
        ((com.tencent.mm.plugin.lite.jsapi.a)localObject1).vkn = ((b)localObject2);
        localObject3 = paramJsApi.appId;
        localJSONObject = new JSONObject(paramJsApi.param);
        if (((com.tencent.mm.plugin.lite.jsapi.a)localObject1).cZP() == 0)
        {
          ((com.tencent.mm.plugin.lite.jsapi.a)localObject1).vko = new a.a();
          ((com.tencent.mm.plugin.lite.jsapi.a)localObject1).vko.vkn = ((com.tencent.mm.plugin.lite.jsapi.a)localObject1).vkn;
          ((com.tencent.mm.plugin.lite.jsapi.a)localObject1).j((String)localObject3, localJSONObject);
          AppMethodBeat.o(212341);
          return;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.LiteAppCenter", localException, "invokeJsApi", new Object[0]);
        if (paramJsApi.callbackId > 0L) {
          jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg:\"exception\" data: {}}", false);
        }
        AppMethodBeat.o(212341);
        return;
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("data", localJSONObject.toString());
      ((Bundle)localObject2).putString("appId", (String)localObject3);
      Object localObject3 = new a.3(localException);
      h.a(ak.getPackageName(), (Parcelable)localObject2, localException.getClass(), (d)localObject3);
      AppMethodBeat.o(212341);
      return;
    }
  }
  
  public static native void jsApiCallback(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, boolean paramBoolean);
  
  private static void navigateBack(long paramLong)
  {
    AppMethodBeat.i(212358);
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).navigateBack();
    }
    AppMethodBeat.o(212358);
  }
  
  private static void offSystemInfoChange(long paramLong)
  {
    AppMethodBeat.i(212354);
    systemInfoChangeCallback.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(212354);
  }
  
  private static void onCheckSumFail(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(212340);
    if (mCallback != null) {
      mCallback.onCheckSumFail(paramString, paramList);
    }
    AppMethodBeat.o(212340);
  }
  
  public static void onSelectConversationUICallback(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(212333);
    com.tencent.mm.plugin.lite.jsapi.a locala = (com.tencent.mm.plugin.lite.jsapi.a)selectConversationUICallbacks.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(212333);
      return;
    }
    removeSelectConversationUICallback(paramInt1);
    locala.e(paramInt2, paramInt3, paramIntent);
    AppMethodBeat.o(212333);
  }
  
  private static void onSystemInfoChange(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(212353);
    systemInfoChangeCallback.put(Long.valueOf(paramLong2), new SystemInfoChangeCallbackInfo(paramString, paramLong1, paramLong2, paramLong3));
    AppMethodBeat.o(212353);
  }
  
  private static void openPage(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212359);
    if (mCallback != null) {
      mCallback.openPage(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(212359);
  }
  
  public static native void preloadIndexView(String paramString1, String paramString2, String paramString3);
  
  public static native void preloadView(String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native void preloadViewBaseLib(int paramInt);
  
  public static native void publishGlobalEvent(long paramLong1, long paramLong2, String paramString);
  
  private static void releasePage(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212346);
    systemInfoChangeCallback.remove(Long.valueOf(paramLong2));
    pageInfos.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(212346);
  }
  
  public static void removeSelectConversationUICallback(int paramInt)
  {
    AppMethodBeat.i(212332);
    selectConversationUICallbacks.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(212332);
  }
  
  private static void reportIdKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(212351);
    g.yxI.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(212351);
  }
  
  private static void reportKv(int paramInt, String paramString)
  {
    AppMethodBeat.i(212350);
    g.yxI.a(paramInt, paramString, false, false);
    AppMethodBeat.o(212350);
  }
  
  public static native void setAuthInfo(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2);
  
  public static void setCallback(ILiteAppCallback paramILiteAppCallback)
  {
    mCallback = paramILiteAppCallback;
  }
  
  private static native void setDarkMode(boolean paramBoolean);
  
  public static native void setDisplayParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5);
  
  private static void setFlags(long paramLong, int paramInt)
  {
    AppMethodBeat.i(212345);
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).setFlags(paramInt);
    }
    AppMethodBeat.o(212345);
  }
  
  private static void setPageInfo(long paramLong1, long paramLong2, PageInfo paramPageInfo)
  {
    AppMethodBeat.i(212348);
    pageInfos.put(Long.valueOf(paramLong2), paramPageInfo);
    AppMethodBeat.o(212348);
  }
  
  public static void setPath(String paramString)
  {
    AppMethodBeat.i(212330);
    setPath(paramString, new HostInfo());
    AppMethodBeat.o(212330);
  }
  
  private static native void setPath(String paramString, HostInfo paramHostInfo);
  
  private static void setTitle(long paramLong, String paramString)
  {
    AppMethodBeat.i(212342);
    PageInfo localPageInfo = (PageInfo)pageInfos.get(Long.valueOf(pageId));
    if (localPageInfo != null) {
      localPageInfo.title = paramString;
    }
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).setTitle(paramString);
    }
    AppMethodBeat.o(212342);
  }
  
  private static void setTitleAlpha(long paramLong, int paramInt)
  {
    AppMethodBeat.i(212343);
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).setTitleAlpha(paramInt);
    }
    AppMethodBeat.o(212343);
  }
  
  public static void setUICallback(long paramLong, ILiteAppUICallback paramILiteAppUICallback)
  {
    AppMethodBeat.i(212338);
    mUICallback.put(Long.valueOf(paramLong), paramILiteAppUICallback);
    AppMethodBeat.o(212338);
  }
  
  public static PageInfo showIndexView(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212336);
    paramString1 = _showIndexView(paramString1, paramString2, paramString3, paramString4);
    pageInfos.put(Long.valueOf(paramString1.pageId), paramString1);
    pageId = paramString1.pageId;
    AppMethodBeat.o(212336);
    return paramString1;
  }
  
  private static void showMenuBtn(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(212344);
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).showMenuBtn(paramBoolean);
    }
    AppMethodBeat.o(212344);
  }
  
  private static void showPage(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212347);
    if (mUICallback.containsKey(Long.valueOf(paramLong1)))
    {
      PageInfo localPageInfo = (PageInfo)pageInfos.get(Long.valueOf(paramLong2));
      if (localPageInfo != null) {
        ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).showPage(localPageInfo);
      }
    }
    AppMethodBeat.o(212347);
  }
  
  public static PageInfo showView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(212337);
    paramString1 = _showView(paramString1, paramString2, paramString3, paramString4, paramString5);
    pageInfos.put(Long.valueOf(paramString1.pageId), paramString1);
    pageId = paramString1.pageId;
    AppMethodBeat.o(212337);
    return paramString1;
  }
  
  private static void systemInfoChange(String paramString)
  {
    AppMethodBeat.i(212335);
    Iterator localIterator = systemInfoChangeCallback.values().iterator();
    while (localIterator.hasNext())
    {
      SystemInfoChangeCallbackInfo localSystemInfoChangeCallbackInfo = (SystemInfoChangeCallbackInfo)localIterator.next();
      jsApiCallback(localSystemInfoChangeCallbackInfo.appId, localSystemInfoChangeCallbackInfo.appPtr, localSystemInfoChangeCallbackInfo.pageId, localSystemInfoChangeCallbackInfo.callbackId, paramString, true);
    }
    AppMethodBeat.o(212335);
  }
  
  public static void unsetUICallback(long paramLong, ILiteAppUICallback paramILiteAppUICallback)
  {
    AppMethodBeat.i(212339);
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      mUICallback.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(212339);
  }
  
  public static void updateDarkMode(boolean paramBoolean)
  {
    AppMethodBeat.i(212334);
    setDarkMode(paramBoolean);
    systemInfoChange("{\"darkMode\": " + String.valueOf(paramBoolean) + "}");
    AppMethodBeat.o(212334);
  }
  
  static class HostInfo
  {
    public String appBranch;
    public String appBuildJob;
    public String appBuildTime;
    public String appFlavor;
    public String appRevision;
    public String appVersion;
    public Map<String, String> otherExtends;
    public String system;
    public String systemVersion;
    
    HostInfo()
    {
      AppMethodBeat.i(212324);
      this.system = "Android";
      this.systemVersion = ("Android " + Build.VERSION.RELEASE);
      this.appVersion = com.tencent.mm.sdk.platformtools.j.hju;
      this.appRevision = com.tencent.mm.sdk.platformtools.j.REV;
      this.appBranch = com.tencent.mm.sdk.platformtools.j.BUILD_TAG;
      this.appBuildJob = com.tencent.mm.sdk.platformtools.j.HOSTNAME;
      this.appBuildTime = com.tencent.mm.sdk.platformtools.j.TIME;
      if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) {}
      for (String str = "red";; str = "release")
      {
        this.appFlavor = str;
        AppMethodBeat.o(212324);
        return;
      }
    }
  }
  
  public static abstract interface ILiteAppCallback
  {
    public abstract String[] getAppInfo(String paramString);
    
    public abstract void onCheckSumFail(String paramString, List<String> paramList);
    
    public abstract void openPage(String paramString1, String paramString2, String paramString3);
  }
  
  public static abstract interface ILiteAppUICallback
  {
    public abstract boolean hasCutOut();
    
    public abstract void navigateBack();
    
    public abstract void setFlags(int paramInt);
    
    public abstract void setTitle(String paramString);
    
    public abstract void setTitleAlpha(int paramInt);
    
    public abstract void showMenuBtn(boolean paramBoolean);
    
    public abstract void showPage(LiteAppCenter.PageInfo paramPageInfo);
  }
  
  static class JsApi
  {
    public String appId;
    public long appPtr;
    public long callbackId;
    public String method;
    public long pageId;
    public String param;
    
    public JsApi(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, long paramLong3)
    {
      this.appId = paramString1;
      this.appPtr = paramLong1;
      this.pageId = paramLong2;
      this.method = paramString2;
      this.param = paramString3;
      this.callbackId = paramLong3;
    }
    
    public String toString()
    {
      AppMethodBeat.i(212325);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("appid:").append(this.appId).append(" appPtr:").append(this.appPtr).append(" pageId:").append(this.pageId).append(" method:").append(this.method).append(" param:").append(this.param).append(" callback:").append(this.callbackId);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(212325);
      return localObject;
    }
  }
  
  public static class PageInfo
  {
    public long appPtr;
    public String basePath;
    public String darkTitleBackgroundColor;
    public String darkTitleColor;
    public int flags;
    public long pageId;
    public String pageUrl;
    public long renderId;
    public boolean showMenu;
    public boolean success;
    public String title;
    public String titleBackgroundColor;
    public String titleColor;
    
    public PageInfo(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, boolean paramBoolean2)
    {
      this.success = paramBoolean1;
      this.appPtr = paramLong1;
      this.pageId = paramLong2;
      this.renderId = paramLong3;
      this.basePath = paramString1;
      this.pageUrl = paramString2;
      this.title = paramString3;
      this.titleColor = paramString4;
      this.darkTitleColor = paramString5;
      this.titleBackgroundColor = paramString6;
      this.darkTitleBackgroundColor = paramString7;
      this.flags = paramInt;
      this.showMenu = paramBoolean2;
    }
  }
  
  static class SystemInfoChangeCallbackInfo
  {
    public String appId;
    public long appPtr;
    public long callbackId;
    public long pageId;
    
    public SystemInfoChangeCallbackInfo(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      this.appId = paramString;
      this.appPtr = paramLong1;
      this.pageId = paramLong2;
      this.callbackId = paramLong3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.LiteAppCenter
 * JD-Core Version:    0.7.0.1
 */