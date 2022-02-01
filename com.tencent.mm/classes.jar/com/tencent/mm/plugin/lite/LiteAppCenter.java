package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ap;
import java.lang.reflect.Constructor;
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
  public static final String LITE_APP_GAME_CENTER = "wxalited0d6cb88ac866bcdf3b738f1f3df8872";
  private static final String TAG = "MicroMsg.LiteAppCenter";
  private static ILiteAppCallback mCallback;
  private static ILiteAppUICallback mUICallback;
  private static Map<String, Map<String, Class<? extends a>>> sAppLevelApi;
  private static Map<String, Class<? extends a>> sCommApi;
  
  static
  {
    AppMethodBeat.i(208142);
    System.loadLibrary("wechatlv");
    sCommApi = new ConcurrentHashMap();
    sAppLevelApi = new ConcurrentHashMap();
    AppMethodBeat.o(208142);
  }
  
  private static native void addJsApi(String paramString);
  
  public static void addJsApi(String paramString, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(208127);
    if (sCommApi.containsKey(paramString))
    {
      paramString = new RuntimeException(paramString + " has been exists");
      AppMethodBeat.o(208127);
      throw paramString;
    }
    sCommApi.put(paramString, paramClass);
    addJsApi(paramString);
    AppMethodBeat.o(208127);
  }
  
  private static native void addJsApi(String paramString1, String paramString2);
  
  public static void addJsApi(String paramString1, String paramString2, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(208129);
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
      AppMethodBeat.o(208129);
      throw paramString1;
    }
    ((Map)localObject).put(paramString2, paramClass);
    addJsApi(paramString1, paramString2);
    AppMethodBeat.o(208129);
  }
  
  public static void addJsApi(String paramString, Map<String, Class<? extends a>> paramMap)
  {
    AppMethodBeat.i(208130);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      addJsApi(paramString, (String)localEntry.getKey(), (Class)localEntry.getValue());
    }
    AppMethodBeat.o(208130);
  }
  
  public static void addJsApi(Map<String, Class<? extends a>> paramMap)
  {
    AppMethodBeat.i(208128);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      addJsApi((String)localEntry.getKey(), (Class)localEntry.getValue());
    }
    AppMethodBeat.o(208128);
  }
  
  private static boolean getAppInfo(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(208136);
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 2))
    {
      ac.e("MicroMsg.LiteAppCenter", "info invalid");
      AppMethodBeat.o(208136);
      return false;
    }
    if (mCallback != null)
    {
      paramString = mCallback.getAppInfo(paramString);
      if ((paramString == null) || (paramString.length != paramArrayOfString.length))
      {
        AppMethodBeat.o(208136);
        return false;
      }
      paramArrayOfString[0] = paramString[0];
      paramArrayOfString[1] = paramString[1];
    }
    AppMethodBeat.o(208136);
    return false;
  }
  
  public static native String getAuthUrl(String paramString1, String paramString2, String paramString3);
  
  private static String getSystemInfo()
  {
    AppMethodBeat.i(208139);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("brand", Build.MANUFACTURER);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("language", ab.iC(ai.getContext()));
      ((JSONObject)localObject).put("platform", "Android");
      ((JSONObject)localObject).put("system", "Android " + Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("version", com.tencent.mm.sdk.platformtools.h.gMJ);
      float f = ai.getContext().getResources().getDisplayMetrics().density;
      ((JSONObject)localObject).put("pixelRatio", f);
      ((JSONObject)localObject).put("navigationBarHeight", ap.ej(ai.getContext()) / f);
      ((JSONObject)localObject).put("statusBarHeight", ap.jL(ai.getContext()) / f);
      ((JSONObject)localObject).put("titleBarHeight", ap.dT(ai.getContext()) / f);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(208139);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(208139);
    }
    return "";
  }
  
  private static String getUserAgent()
  {
    int i = 0;
    AppMethodBeat.i(208140);
    Object localObject2 = "NoNet";
    for (;;)
    {
      try
      {
        Object localObject3 = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
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
          localObject3 = ai.getContext().getPackageManager().getPackageInfo(ai.getPackageName(), 0);
          localObject4 = ((PackageInfo)localObject3).versionName;
          i = ((PackageInfo)localObject3).versionCode;
          String str2 = Build.VERSION.RELEASE;
          String str3 = Build.MODEL;
          String str4 = Build.ID;
          String str5 = com.tencent.mm.sdk.platformtools.h.gMJ;
          String str6 = ab.eUO();
          if (com.tencent.mm.sdk.platformtools.h.gMM)
          {
            localObject3 = "arm64";
            localObject1 = String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045140 Mobile Safari/537.36 MMWEBID/3371 MicroMessenger/%s.%d(%s) Process/lite NetType/%s Language/%s ABI/%s WeChat/%s", new Object[] { str2, str3, str4, localObject4, Integer.valueOf(i), str5, localObject1, str6, localObject2, localObject3 });
            ac.i("MicroMsg.LiteAppCenter", "get user agent:".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(208140);
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
        AppMethodBeat.o(208140);
        return str1;
      }
      continue;
      String str1 = "4G";
      continue;
      i += 1;
    }
  }
  
  private static void invokeJsApi(JsApi paramJsApi)
  {
    AppMethodBeat.i(208133);
    ac.i("MicroMsg.LiteAppCenter", "invokeJsApi:".concat(String.valueOf(paramJsApi)));
    for (;;)
    {
      try
      {
        if (paramJsApi.appId == null)
        {
          ac.e("MicroMsg.LiteAppCenter", "invalid api ".concat(String.valueOf(paramJsApi)));
          AppMethodBeat.o(208133);
          return;
        }
        if ((paramJsApi.method == null) || (paramJsApi.param == null))
        {
          ac.e("MicroMsg.LiteAppCenter", "invalid api ".concat(String.valueOf(paramJsApi)));
          if (paramJsApi.callbackId > 0L) {
            jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, data: {msg: 'invalid api'}}", false);
          }
          AppMethodBeat.o(208133);
          return;
        }
        Object localObject = null;
        if (sAppLevelApi.containsKey(paramJsApi.appId)) {
          localObject = (Class)((Map)sAppLevelApi.get(paramJsApi.appId)).get(paramJsApi.method);
        }
        if (localObject == null)
        {
          localObject = (Class)sCommApi.get(paramJsApi.method);
          if (localObject == null)
          {
            ac.e("MicroMsg.LiteAppCenter", "not found api ".concat(String.valueOf(paramJsApi)));
            if (paramJsApi.callbackId > 0L) {
              jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, data: {msg: 'not found'}}", false);
            }
            AppMethodBeat.o(208133);
            return;
          }
          b localb = new b(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId);
          localObject = (a)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
          ((a)localObject).setCallback(localb);
          ((a)localObject).invokeJsApi(paramJsApi.appId, new JSONObject(paramJsApi.param));
          AppMethodBeat.o(208133);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.LiteAppCenter", localException, "invokeJsApi", new Object[0]);
        if (paramJsApi.callbackId > 0L) {
          jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, data: {msg: 'exception'}}", false);
        }
        AppMethodBeat.o(208133);
        return;
      }
    }
  }
  
  public static native void jsApiCallback(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, boolean paramBoolean);
  
  private static void navigateBack()
  {
    AppMethodBeat.i(208141);
    if (mUICallback != null) {
      mUICallback.navigateBack();
    }
    AppMethodBeat.o(208141);
  }
  
  private static void onCheckSumFail(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(208132);
    if (mCallback != null) {
      mCallback.onCheckSumFail(paramString, paramList);
    }
    AppMethodBeat.o(208132);
  }
  
  public static native void preloadIndexView(String paramString1, String paramString2, String paramString3);
  
  public static native void preloadView(String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native void preloadViewBaseLib(int paramInt);
  
  private static void reportIdKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(208138);
    com.tencent.mm.plugin.report.service.h.wUl.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(208138);
  }
  
  private static void reportKv(int paramInt, String paramString)
  {
    AppMethodBeat.i(208137);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(paramInt, paramString);
    AppMethodBeat.o(208137);
  }
  
  public static native void setAuthInfo(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2);
  
  public static void setCallback(ILiteAppCallback paramILiteAppCallback)
  {
    mCallback = paramILiteAppCallback;
  }
  
  public static native void setDarkMode(boolean paramBoolean);
  
  public static native void setDisplayParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5);
  
  public static void setPath(String paramString)
  {
    AppMethodBeat.i(208131);
    setPath(paramString, new HostInfo());
    AppMethodBeat.o(208131);
  }
  
  private static native void setPath(String paramString, HostInfo paramHostInfo);
  
  private static void setTitle(String paramString)
  {
    AppMethodBeat.i(208134);
    if (mUICallback != null) {
      mUICallback.setTitle(paramString);
    }
    AppMethodBeat.o(208134);
  }
  
  private static void setTitleAlpha(int paramInt)
  {
    AppMethodBeat.i(208135);
    if (mUICallback != null) {
      mUICallback.setTitleAlpha(paramInt);
    }
    AppMethodBeat.o(208135);
  }
  
  public static void setUICallback(ILiteAppUICallback paramILiteAppUICallback)
  {
    mUICallback = paramILiteAppUICallback;
  }
  
  public static native PageInfo showIndexView(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native PageInfo showView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public static void unsetUICallback(ILiteAppUICallback paramILiteAppUICallback)
  {
    if (paramILiteAppUICallback == mUICallback) {
      mUICallback = null;
    }
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
      AppMethodBeat.i(208125);
      this.system = "Android";
      this.systemVersion = ("Android " + Build.VERSION.RELEASE);
      this.appVersion = com.tencent.mm.sdk.platformtools.h.gMJ;
      this.appRevision = com.tencent.mm.sdk.platformtools.h.REV;
      this.appBranch = com.tencent.mm.sdk.platformtools.h.BUILD_TAG;
      this.appBuildJob = com.tencent.mm.sdk.platformtools.h.HOSTNAME;
      this.appBuildTime = com.tencent.mm.sdk.platformtools.h.TIME;
      if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {}
      for (String str = "red";; str = "release")
      {
        this.appFlavor = str;
        AppMethodBeat.o(208125);
        return;
      }
    }
  }
  
  public static abstract interface ILiteAppCallback
  {
    public abstract String[] getAppInfo(String paramString);
    
    public abstract void onCheckSumFail(String paramString, List<String> paramList);
  }
  
  public static abstract interface ILiteAppUICallback
  {
    public abstract void navigateBack();
    
    public abstract void setTitle(String paramString);
    
    public abstract void setTitleAlpha(int paramInt);
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
      AppMethodBeat.i(208126);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("appid:").append(this.appId).append(" appPtr:").append(this.appPtr).append(" pageId:").append(this.pageId).append(" method:").append(this.method).append(" param:").append(this.param).append(" callback:").append(this.callbackId);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(208126);
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
    public boolean success;
    public String title;
    public String titleBackgroundColor;
    public String titleColor;
    
    public PageInfo(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
    {
      this.success = paramBoolean;
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.LiteAppCenter
 * JD-Core Version:    0.7.0.1
 */