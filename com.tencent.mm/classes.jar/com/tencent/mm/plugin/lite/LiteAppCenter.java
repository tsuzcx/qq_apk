package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.b.a;
import com.tencent.liteapp.c.h;
import com.tencent.liteapp.jsapi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public abstract class LiteAppCenter
{
  public static final String LITE_APP_BASE_LIB = "wxalitebaselibrary";
  private static final String TAG = "WxaLiteApp.LiteAppCenter";
  private static String lastPath = "";
  public static IWxaLiteAppCallback mCallback;
  public static Map<Long, ILiteAppUICallback> mUICallback;
  private static long pageId;
  private static HashMap<Long, PageInfo> pageInfos;
  private static Map<String, Map<String, Class<? extends a>>> sAppLevelApi;
  private static Map<String, Class<? extends a>> sCommApi;
  private static HashMap<Long, SystemInfoChangeCallbackInfo> systemInfoChangeCallback;
  
  static
  {
    System.loadLibrary("mmv8");
    System.loadLibrary("flutter");
    System.loadLibrary("wechatlv");
    System.loadLibrary("wxajs");
    System.loadLibrary("wcwss");
    System.loadLibrary("owl");
    systemInfoChangeCallback = new HashMap();
    pageInfos = new HashMap();
    pageId = -1L;
    sCommApi = new ConcurrentHashMap();
    sAppLevelApi = new ConcurrentHashMap();
    mUICallback = new ConcurrentHashMap();
  }
  
  private static native PageInfo _showIndexView(String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native PageInfo _showView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  private static native void addJsApi(String paramString);
  
  public static void addJsApi(String paramString, Class<? extends a> paramClass)
  {
    if (sCommApi.containsKey(paramString)) {
      throw new RuntimeException(paramString + " has been exists");
    }
    sCommApi.put(paramString, paramClass);
    addJsApi(paramString);
  }
  
  private static native void addJsApi(String paramString1, String paramString2);
  
  public static void addJsApi(String paramString1, String paramString2, Class<? extends a> paramClass)
  {
    Map localMap = (Map)sAppLevelApi.get(paramString1);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      sAppLevelApi.put(paramString1, localObject);
    }
    if (((Map)localObject).containsKey(paramString2)) {
      throw new RuntimeException(paramString1 + ":" + paramString2 + " has been exists");
    }
    ((Map)localObject).put(paramString2, paramClass);
    addJsApi(paramString1, paramString2);
  }
  
  public static void addJsApi(String paramString, Map<String, Class> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!a.class.isAssignableFrom((Class)localEntry.getValue())) {
        throw new RuntimeException(paramString + ":api must be subclass of WxaLiteAppJsApi");
      }
      addJsApi(paramString, (String)localEntry.getKey(), (Class)localEntry.getValue());
    }
  }
  
  public static void addJsApi(Map<String, Class> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!a.class.isAssignableFrom((Class)localEntry.getValue())) {
        throw new RuntimeException("api must be subclass of WxaLiteAppJsApi");
      }
      addJsApi((String)localEntry.getKey(), (Class)localEntry.getValue());
    }
  }
  
  private static void dataReporting(String paramString1, String paramString2)
  {
    if (mCallback != null) {
      mCallback.dataReporting(paramString1, paramString2);
    }
  }
  
  private static void dispatchCmdNoRet(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    i = -1;
    switch (paramString2.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!paramString2.equals("vibrateLong")) {
          break;
        }
        i = 0;
        break;
        if (!paramString2.equals("vibrateShort")) {
          break;
        }
        i = 1;
        break;
      } while (!mUICallback.containsKey(Long.valueOf(paramLong1)));
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).vibrateLong(400L);
      return;
    } while (!mUICallback.containsKey(Long.valueOf(paramLong1)));
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString3);
        if (!paramString1.has("type")) {
          continue;
        }
        paramString1 = paramString1.getString("type");
        bool = "heavy".equals(paramString1);
        if (!bool) {
          continue;
        }
        i = 255;
      }
      catch (JSONException paramString1)
      {
        boolean bool;
        i = 192;
        continue;
      }
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).vibrateShort(15L, i);
      return;
      bool = "light".equals(paramString1);
      if (bool) {
        i = 128;
      } else {
        i = 192;
      }
    }
  }
  
  private static String dispatchCmdWithRet(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    return "";
  }
  
  public static native void dispatchStore(String paramString1, String paramString2, String paramString3);
  
  private static String getAppFilePath()
  {
    if (mCallback != null) {
      return mCallback.getLiteAppRoot();
    }
    Object localObject = h.coW;
    localObject = new StringBuilder();
    b.a locala = com.tencent.liteapp.b.cox;
    return b.a.getAppContext().getFilesDir() + "/liteapp";
  }
  
  private static boolean getAppInfo(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 2)) {
      com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "info invalid", new Object[0]);
    }
    do
    {
      do
      {
        return false;
      } while (mCallback == null);
      paramString = mCallback.getAppInfo(paramString);
    } while ((paramString == null) || (paramString.length != paramArrayOfString.length));
    paramArrayOfString[0] = paramString[0];
    paramArrayOfString[1] = paramString[1];
    return false;
  }
  
  public static native String getAuthUrl(String paramString1, String paramString2, String paramString3);
  
  public static native String getBaseLibBuildTypeByPath(String paramString);
  
  public static native String getBaseLibBuildTypeByString(String paramString);
  
  public static native String getBaseLibVersionByPath(String paramString);
  
  public static native String getBaseLibVersionByString(String paramString);
  
  public static String getLastPath()
  {
    return lastPath;
  }
  
  public static native String getLiteAppVersion(String paramString1, String paramString2, String paramString3);
  
  private static String getOfflineResource(String paramString1, String paramString2, String paramString3)
  {
    if (mCallback != null) {
      return mCallback.getOfflineResource(paramString1, paramString2, paramString3);
    }
    return "";
  }
  
  private static String getSystemInfo()
  {
    if (mCallback != null) {
      return mCallback.getSystemInfo().toJasonString();
    }
    return "";
  }
  
  private static String getUin()
  {
    if (mCallback != null) {
      return mCallback.getUin();
    }
    return "";
  }
  
  private static String getUserAgent()
  {
    if (mCallback != null) {
      return mCallback.getUserAgent();
    }
    return "";
  }
  
  private static boolean hasCutOut(long paramLong)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      return ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).hasCutOut();
    }
    return false;
  }
  
  private static void hideKeyboard()
  {
    if (mCallback != null) {
      mCallback.hideKeyboard();
    }
  }
  
  private static void invokeJsApi(JsApi paramJsApi)
  {
    com.tencent.liteapp.b.b.i("WxaLiteApp.LiteAppCenter", "invokeJsApi:%s", new Object[] { paramJsApi.toString() });
    try
    {
      if (paramJsApi.appId == null)
      {
        com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "invalid api", new Object[0]);
        return;
      }
      if ((paramJsApi.method == null) || (paramJsApi.param == null))
      {
        com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "invalid api ", new Object[0]);
        if (paramJsApi.callbackId <= 0L) {
          return;
        }
        jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg: \"invalid api\", data: {}}", false, paramJsApi.isFromView);
      }
    }
    catch (Exception localException)
    {
      com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "invokeJsApi :%s", new Object[] { localException.toString() });
      if (paramJsApi.callbackId > 0L)
      {
        jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg:\"exception\" data: {}}", false, paramJsApi.isFromView);
        return;
        Object localObject = null;
        if (sAppLevelApi.containsKey(paramJsApi.appId)) {
          localObject = (Class)((Map)sAppLevelApi.get(paramJsApi.appId)).get(paramJsApi.method);
        }
        if (localObject == null) {
          localObject = (Class)sCommApi.get(paramJsApi.method);
        }
        for (;;)
        {
          if (localObject == null)
          {
            com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "not found api ", new Object[0]);
            if (paramJsApi.callbackId <= 0L) {
              break;
            }
            jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg:\"not found\" ,data: {}}", false, paramJsApi.isFromView);
            return;
          }
          com.tencent.liteapp.jsapi.b localb = new com.tencent.liteapp.jsapi.b(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, paramJsApi.isFromView);
          localObject = (a)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
          ((a)localObject).a(localb);
          ((a)localObject).b(paramJsApi.appId, new JSONObject(paramJsApi.param), paramJsApi.isFromView);
          return;
        }
      }
    }
  }
  
  public static native void jsApiCallback(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static void navigateBack(long paramLong, boolean paramBoolean)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).navigateBack(paramBoolean);
    }
  }
  
  private static void offSystemInfoChange(long paramLong)
  {
    systemInfoChangeCallback.remove(Long.valueOf(paramLong));
  }
  
  private static void onCheckSumFail(String paramString, long paramLong, List<String> paramList)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).onCheckSumFail(paramString, paramList);
    }
  }
  
  public static native void onEventTriggered(String paramString1, String paramString2);
  
  private static void onSystemInfoChange(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    systemInfoChangeCallback.put(Long.valueOf(paramLong2), new SystemInfoChangeCallbackInfo(paramString, paramLong1, paramLong2, paramLong3));
  }
  
  private static void openPage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (mCallback != null) {
      mCallback.openPage(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public static native void preloadIndexView(String paramString1, String paramString2, String paramString3);
  
  public static native void preloadView(String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native void preloadViewBaseLib(int paramInt);
  
  public static native void publishGlobalEvent(long paramLong1, long paramLong2, String paramString);
  
  public static native void release();
  
  private static void releasePage(long paramLong1, long paramLong2)
  {
    systemInfoChangeCallback.remove(Long.valueOf(paramLong2));
    pageInfos.remove(Long.valueOf(paramLong2));
  }
  
  private static void reloadDebug(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    int i = 0;
    com.tencent.liteapp.b.b.i("WxaLiteApp.LiteAppCenter", "[liteDebug] reloadDebug, appId=" + paramString1 + ";appPtr=" + paramLong + ";pageCount=" + paramInt + "; qrcodeDebugQueryString=" + paramString2, new Object[0]);
    while (i < paramInt)
    {
      navigateBack(paramLong, true);
      i += 1;
    }
    if (mCallback != null) {
      mCallback.reloadDebug(paramString1, paramString2);
    }
  }
  
  private static void reportIdKey(long paramLong1, long paramLong2, long paramLong3)
  {
    if (mCallback != null) {
      mCallback.reportIdKey(paramLong1, paramLong2, paramLong3);
    }
  }
  
  private static void reportKv(int paramInt, String paramString)
  {
    if (mCallback != null) {
      mCallback.reportKv(paramInt, paramString);
    }
  }
  
  public static native void setAuthInfo(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean);
  
  public static native void setCookie(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  private static native void setDarkMode(boolean paramBoolean);
  
  public static native void setDeveloperFlag(boolean paramBoolean);
  
  public static native void setDisplayParams(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);
  
  private static void setFlags(long paramLong, int paramInt)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).setFlags(paramInt);
    }
  }
  
  private static void setPageInfo(long paramLong1, long paramLong2, PageInfo paramPageInfo)
  {
    pageInfos.put(Long.valueOf(paramLong2), paramPageInfo);
  }
  
  public static void setPath(String paramString)
  {
    lastPath = paramString;
    HostInfo localHostInfo = new HostInfo();
    if (mCallback != null) {
      localHostInfo = mCallback.getHostInfo();
    }
    setPath(paramString, localHostInfo);
  }
  
  public static native void setPath(String paramString, HostInfo paramHostInfo);
  
  public static void setPath(String paramString, Map<String, String> paramMap)
  {
    lastPath = paramString;
    HostInfo localHostInfo = new HostInfo();
    if (mCallback != null) {
      localHostInfo = mCallback.getHostInfo();
    }
    for (;;)
    {
      localHostInfo.otherExtends = new HashMap();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localHostInfo.otherExtends.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      setPath(paramString, localHostInfo);
      return;
    }
  }
  
  public static native void setSafeAreaInsets(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean);
  
  public static native void setSystemBarHeight(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public static void setUICallback(long paramLong, ILiteAppUICallback paramILiteAppUICallback)
  {
    mUICallback.put(Long.valueOf(paramLong), paramILiteAppUICallback);
  }
  
  public static void setWxaLiteAppCallback(IWxaLiteAppCallback paramIWxaLiteAppCallback)
  {
    mCallback = paramIWxaLiteAppCallback;
  }
  
  public static PageInfo showIndexView(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = _showIndexView(paramString1, paramString2, paramString3, paramString4);
    pageInfos.put(Long.valueOf(paramString1.pageId), paramString1);
    pageId = paramString1.pageId;
    return paramString1;
  }
  
  private static void showPage(long paramLong1, long paramLong2)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong1)))
    {
      PageInfo localPageInfo = (PageInfo)pageInfos.get(Long.valueOf(paramLong2));
      if (localPageInfo != null) {
        ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).showPage(localPageInfo);
      }
    }
  }
  
  public static PageInfo showView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = _showView(paramString1, paramString2, paramString3, paramString4, paramString5);
    pageInfos.put(Long.valueOf(paramString1.pageId), paramString1);
    pageId = paramString1.pageId;
    return paramString1;
  }
  
  private static void systemInfoChange(String paramString)
  {
    Iterator localIterator = systemInfoChangeCallback.values().iterator();
    while (localIterator.hasNext())
    {
      SystemInfoChangeCallbackInfo localSystemInfoChangeCallbackInfo = (SystemInfoChangeCallbackInfo)localIterator.next();
      jsApiCallback(localSystemInfoChangeCallbackInfo.appId, localSystemInfoChangeCallbackInfo.appPtr, localSystemInfoChangeCallbackInfo.pageId, localSystemInfoChangeCallbackInfo.callbackId, paramString, true, true);
    }
  }
  
  public static void unsetUICallback(long paramLong, ILiteAppUICallback paramILiteAppUICallback)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      mUICallback.remove(Long.valueOf(paramLong));
    }
  }
  
  public static void updateDarkMode(boolean paramBoolean)
  {
    setDarkMode(paramBoolean);
    systemInfoChange("{\"darkMode\": " + String.valueOf(paramBoolean) + "}");
  }
  
  public static void updateDisplayParam(Context paramContext, long paramLong)
  {
    Point localPoint = com.tencent.mm.ext.ui.e.au(paramContext);
    Object localObject = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    int i = localPoint.x;
    int j = localPoint.y;
    localObject = Float.valueOf(localDisplayMetrics.density);
    int k = com.tencent.liteapp.d.e.at(paramContext);
    int m = com.tencent.liteapp.d.e.aB(paramContext);
    float f = 48.0F * ((Float)localObject).floatValue();
    setDisplayParams(paramLong, i / ((Float)localObject).floatValue(), j / ((Float)localObject).floatValue(), localPoint.x / ((Float)localObject).floatValue(), localPoint.y / ((Float)localObject).floatValue(), localDisplayMetrics.densityDpi, ((Float)localObject).floatValue(), f / ((Float)localObject).floatValue(), k / ((Float)localObject).floatValue(), m / ((Float)localObject).floatValue());
    com.tencent.liteapp.b.b.i("WxaLiteApp.LiteAppCenter", "updateLvCppDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.densityDpi), localObject, Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) });
  }
  
  public static boolean versionGreater(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramString2 == null);
      bool1 = bool2;
    } while (paramString2.isEmpty());
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int j = Math.min(paramString1.length, paramString2.length);
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (!paramString1[i].equals(paramString2[i]))
      {
        bool1 = bool2;
        if (paramString1[i].length() > paramString2[i].length()) {
          break;
        }
        if (paramString1[i].length() < paramString2[i].length()) {
          return false;
        }
        bool1 = bool2;
        if (paramString1[i].compareTo(paramString2[i]) > 0) {
          break;
        }
        return false;
      }
      i += 1;
    }
  }
  
  public static class HostInfo
  {
    public String appBranch = "";
    public String appBuildJob = "";
    public String appBuildTime = "";
    public String appFlavor = "";
    public String appRevision = "";
    public String appVersion = "";
    public Map<String, String> otherExtends;
    public String system = "";
    public String systemVersion = "";
  }
  
  public static abstract interface ILiteAppUICallback
  {
    public abstract boolean hasCutOut();
    
    public abstract void navigateBack(boolean paramBoolean);
    
    public abstract void onCheckSumFail(String paramString, List<String> paramList);
    
    public abstract void setFlags(int paramInt);
    
    public abstract void showPage(LiteAppCenter.PageInfo paramPageInfo);
    
    public abstract void vibrateLong(long paramLong);
    
    public abstract void vibrateShort(long paramLong, int paramInt);
  }
  
  public static abstract interface IWxaLiteAppCallback
  {
    public abstract void dataReporting(String paramString1, String paramString2);
    
    public abstract String[] getAppInfo(String paramString);
    
    public abstract LiteAppCenter.HostInfo getHostInfo();
    
    public abstract String getLiteAppRoot();
    
    public abstract String getOfflineResource(String paramString1, String paramString2, String paramString3);
    
    public abstract LiteAppCenter.SystemInfo getSystemInfo();
    
    public abstract String getUin();
    
    public abstract String getUserAgent();
    
    public abstract void hideKeyboard();
    
    public abstract void openPage(String paramString1, String paramString2, String paramString3, String paramString4);
    
    public abstract void reloadDebug(String paramString1, String paramString2);
    
    public abstract void reportIdKey(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void reportKv(int paramInt, String paramString);
  }
  
  public static class JsApi
  {
    public String appId;
    public long appPtr;
    public long callbackId;
    public boolean isFromView;
    public String method;
    public long pageId;
    public String param;
    
    public JsApi(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, long paramLong3, boolean paramBoolean)
    {
      this.appId = paramString1;
      this.appPtr = paramLong1;
      this.pageId = paramLong2;
      this.method = paramString2;
      this.param = paramString3;
      this.callbackId = paramLong3;
      this.isFromView = paramBoolean;
    }
    
    public String toString()
    {
      AppMethodBeat.i(259095);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("appid:").append(this.appId).append(" appPtr:").append(this.appPtr).append(" pageId:").append(this.pageId).append(" method:").append(this.method).append(" param:").append(this.param).append(" callback:").append(this.callbackId).append(" isFromView:").append(this.isFromView);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(259095);
      return localObject;
    }
  }
  
  public static class PageInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<PageInfo> CREATOR;
    public String appId;
    public long appPtr;
    public long appUuid;
    public String basePath;
    public int flags;
    public long pageId;
    public String pageUrl;
    public long renderId;
    public boolean success;
    
    static
    {
      AppMethodBeat.i(259104);
      CREATOR = new Parcelable.Creator()
      {
        public final LiteAppCenter.PageInfo createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(259096);
          paramAnonymousParcel = new LiteAppCenter.PageInfo(paramAnonymousParcel);
          AppMethodBeat.o(259096);
          return paramAnonymousParcel;
        }
        
        public final LiteAppCenter.PageInfo[] newArray(int paramAnonymousInt)
        {
          return new LiteAppCenter.PageInfo[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(259104);
    }
    
    protected PageInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(259101);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        this.appUuid = paramParcel.readLong();
        this.appPtr = paramParcel.readLong();
        this.pageId = paramParcel.readLong();
        this.renderId = paramParcel.readLong();
        this.basePath = paramParcel.readString();
        this.pageUrl = paramParcel.readString();
        this.flags = paramParcel.readInt();
        this.appId = paramParcel.readString();
        AppMethodBeat.o(259101);
        return;
      }
    }
    
    public PageInfo(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2, int paramInt)
    {
      this.success = paramBoolean;
      this.appUuid = paramLong1;
      this.appPtr = paramLong2;
      this.pageId = paramLong3;
      this.renderId = paramLong4;
      this.basePath = paramString1;
      this.pageUrl = paramString2;
      this.flags = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(259102);
      String str = "PageInfo{success=" + this.success + ", uuid=" + this.appUuid + ", appPtr=" + this.appPtr + ", pageId=" + this.pageId + ", renderId=" + this.renderId + ", basePath='" + this.basePath + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", flags=" + this.flags + '}';
      AppMethodBeat.o(259102);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(259103);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeLong(this.appUuid);
        paramParcel.writeLong(this.appPtr);
        paramParcel.writeLong(this.pageId);
        paramParcel.writeLong(this.renderId);
        paramParcel.writeString(this.basePath);
        paramParcel.writeString(this.pageUrl);
        paramParcel.writeInt(this.flags);
        paramParcel.writeString(this.appId);
        AppMethodBeat.o(259103);
        return;
      }
    }
  }
  
  public static class SystemInfo
  {
    public String brand = "";
    public boolean darkMode = false;
    public String language = "";
    public String model = "";
    public float navigationBarHeight = 0.0F;
    public String networkType = "";
    public float pixelRatio = 0.0F;
    public String platform = "";
    public float statusBarHeight = 0.0F;
    public String system = "";
    public float titleBarHeight = 0.0F;
    public String version = "";
    
    public String toJasonString()
    {
      AppMethodBeat.i(259107);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("networkType", this.networkType);
        ((JSONObject)localObject).put("brand", this.brand);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("language", this.language);
        ((JSONObject)localObject).put("platform", this.platform);
        ((JSONObject)localObject).put("system", this.system);
        ((JSONObject)localObject).put("version", this.version);
        ((JSONObject)localObject).put("pixelRatio", this.pixelRatio);
        ((JSONObject)localObject).put("navigationBarHeight", this.navigationBarHeight);
        ((JSONObject)localObject).put("statusBarHeight", this.statusBarHeight);
        ((JSONObject)localObject).put("titleBarHeight", this.titleBarHeight);
        ((JSONObject)localObject).put("darkMode", this.darkMode);
        localObject = ((JSONObject)localObject).toString();
        AppMethodBeat.o(259107);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "toJasonString JSONException" + localJSONException.toString(), new Object[0]);
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.LiteAppCenter
 * JD-Core Version:    0.7.0.1
 */