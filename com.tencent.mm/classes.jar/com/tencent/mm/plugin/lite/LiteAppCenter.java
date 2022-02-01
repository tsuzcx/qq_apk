package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.b.a;
import com.tencent.liteapp.c.h;
import com.tencent.liteapp.d.f;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import com.tencent.wxa.c;
import com.tencent.wxa.c.1;
import com.tencent.wxa.c.b;
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
  public static final String FRAMEWORK_TYPE_BASE = "base";
  public static final String FRAMEWORK_TYPE_NONE = "none";
  public static final String FRAMEWORK_TYPE_VUE = "Vue";
  public static final String FRAMEWORK_TYPE_VUE3 = "Vue3";
  public static final String LITE_APP_BASE_LIB = "wxalitebaselibrary";
  private static final String TAG = "WxaLiteApp.LiteAppCenter";
  public static float fontScale = 1.0F;
  public static boolean fontScaleFollowSystem = false;
  private static String lastPath = "";
  public static IWxaLiteAppCallback mCallback;
  public static Map<Long, ILiteAppUICallback> mUICallback;
  private static long pageId;
  private static HashMap<Long, PageInfo> pageInfos;
  private static Map<String, Map<String, Class<? extends com.tencent.liteapp.jsapi.a>>> sAppLevelApi;
  private static Map<String, Class<? extends com.tencent.liteapp.jsapi.a>> sCommApi;
  private static Map<String, com.tencent.liteapp.jsapi.a> sWxaLiteAppJsApiMap;
  private static HashMap<Long, SystemInfoChangeCallbackInfo> systemInfoChangeCallback;
  private byte _hellAccFlag_;
  
  static
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("mmv8");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("flutter");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatlv");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("wxajs");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("wcwss");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("owl");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/lite/LiteAppCenter", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    systemInfoChangeCallback = new HashMap();
    pageInfos = new HashMap();
    pageId = -1L;
    sCommApi = new ConcurrentHashMap();
    sAppLevelApi = new ConcurrentHashMap();
    sWxaLiteAppJsApiMap = new ConcurrentHashMap();
    mUICallback = new ConcurrentHashMap();
  }
  
  private static native void addJsApi(String paramString);
  
  public static void addJsApi(String paramString, com.tencent.liteapp.jsapi.a parama)
  {
    sWxaLiteAppJsApiMap.put(paramString, parama);
  }
  
  public static void addJsApi(String paramString, Class<? extends com.tencent.liteapp.jsapi.a> paramClass)
  {
    if (sCommApi.containsKey(paramString)) {
      throw new RuntimeException(paramString + " has been exists");
    }
    sCommApi.put(paramString, paramClass);
    addJsApi(paramString);
  }
  
  private static native void addJsApi(String paramString1, String paramString2);
  
  public static void addJsApi(String paramString1, String paramString2, Class<? extends com.tencent.liteapp.jsapi.a> paramClass)
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
      if (!com.tencent.liteapp.jsapi.a.class.isAssignableFrom((Class)localEntry.getValue())) {
        throw new RuntimeException(paramString + ":api must be subclass of WxaLiteAppJsApi");
      }
      addJsApi(paramString, (String)localEntry.getKey(), (Class)localEntry.getValue());
    }
  }
  
  public static void addJsApi(HashMap<String, com.tencent.liteapp.jsapi.a> paramHashMap)
  {
    sWxaLiteAppJsApiMap.putAll(paramHashMap);
  }
  
  public static void addJsApi(Map<String, Class> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!com.tencent.liteapp.jsapi.a.class.isAssignableFrom((Class)localEntry.getValue())) {
        throw new RuntimeException("api must be subclass of WxaLiteAppJsApi");
      }
      addJsApi((String)localEntry.getKey(), (Class)localEntry.getValue());
    }
  }
  
  public static native int checkBaseLib(String paramString);
  
  public static native int checkLiteAppPkg(String paramString);
  
  public static void closeWindow(long paramLong, Intent paramIntent)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).closeWindow(paramIntent);
    }
  }
  
  public static native void createStore(String paramString1, String paramString2, String paramString3, int paramInt);
  
  private static void dataReporting(String paramString1, String paramString2)
  {
    if (mCallback != null) {
      mCallback.dataReporting(paramString1, paramString2);
    }
  }
  
  private static void dispatchCmdNoRet(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    int i = -1;
    switch (paramString2.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
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
      if (!paramString2.equals("setKeepScreenOn")) {
        break;
      }
      i = 2;
      break;
      if (mUICallback.containsKey(Long.valueOf(paramLong1)))
      {
        ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).vibrateLong(400L);
        return;
        if (mUICallback.containsKey(Long.valueOf(paramLong1)))
        {
          boolean bool;
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
          if (mUICallback.containsKey(Long.valueOf(paramLong1))) {
            try
            {
              paramString1 = new JSONObject(paramString3);
              if (paramString1.has("on"))
              {
                bool = paramString1.getBoolean("on");
                ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).setKeepScreenOn(bool);
                return;
              }
            }
            catch (JSONException paramString1) {}
          }
        }
      }
    }
  }
  
  private static String dispatchCmdWithRet(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    return "";
  }
  
  public static native int dispatchStore(String paramString1, String paramString2, String paramString3);
  
  private static String getAppFilePath()
  {
    if (mCallback != null) {
      return mCallback.getLiteAppRoot();
    }
    Object localObject = h.egi;
    localObject = new StringBuilder();
    b.a locala = com.tencent.liteapp.b.efD;
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
  
  public static native String getBaseLibMajorVersion();
  
  public static native String getBaseLibMajorVersionByPath(String paramString);
  
  public static native String getBaseLibVersionByPath(String paramString);
  
  public static native String getBaseLibVersionByString(String paramString);
  
  public static native int getBaseLibVersionNumber(String paramString);
  
  public static String getLastPath()
  {
    return lastPath;
  }
  
  public static native String getLiteAppMinBaseLibMajorVersion(String paramString1, String paramString2, String paramString3);
  
  public static native String getLiteAppMinLiteAppBaseLib(String paramString1, String paramString2, String paramString3);
  
  public static native String getLiteAppVersion(String paramString1, String paramString2, String paramString3);
  
  private static String getOfflineResource(String paramString1, String paramString2, String paramString3)
  {
    if (mCallback != null) {
      return mCallback.getOfflineResource(paramString1, paramString2, paramString3);
    }
    return "";
  }
  
  public static native int getSdkMaxBaseLibVersionNumber();
  
  public static native int getSdkMaxVersionNumber();
  
  public static native String getSdkMinBaseLibVersion();
  
  public static native int getSdkMinBaseLibVersionNumber();
  
  public static native String getSdkVersion();
  
  public static native int getSdkVersionNumber();
  
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
  
  private static native PageInfo innerShowIndexView(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  private static native PageInfo innerShowView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt);
  
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
        if (sAppLevelApi.containsKey(paramJsApi.appId)) {}
        for (Object localObject1 = (Class)((Map)sAppLevelApi.get(paramJsApi.appId)).get(paramJsApi.method);; localObject1 = null)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = (Class)sCommApi.get(paramJsApi.method);
          }
          if (localObject2 != null) {
            localObject1 = (com.tencent.liteapp.jsapi.a)((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]);
          }
          for (;;)
          {
            if (localObject1 == null)
            {
              com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppCenter", "not found api ", new Object[0]);
              if (paramJsApi.callbackId <= 0L) {
                break;
              }
              jsApiCallback(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, "{result: false, errMsg:\"not found\" ,data: {}}", false, paramJsApi.isFromView);
              return;
              if (sWxaLiteAppJsApiMap.containsKey(paramJsApi.method)) {
                localObject1 = (com.tencent.liteapp.jsapi.a)sWxaLiteAppJsApiMap.get(paramJsApi.method);
              }
            }
            else
            {
              ((com.tencent.liteapp.jsapi.a)localObject1).efV = paramJsApi.method;
              ((com.tencent.liteapp.jsapi.a)localObject1).a(new com.tencent.liteapp.jsapi.b(paramJsApi.appId, paramJsApi.appPtr, paramJsApi.pageId, paramJsApi.callbackId, paramJsApi.isFromView));
              ((com.tencent.liteapp.jsapi.a)localObject1).b(paramJsApi.appId, new JSONObject(paramJsApi.param), paramJsApi.isFromView);
              return;
            }
            localObject1 = null;
          }
        }
      }
    }
  }
  
  public static native void jsApiCallback(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static boolean loadBaseLibByMajorVersion(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getLiteAppMinBaseLibMajorVersion(paramString1, paramString2, paramString3);
    if (paramString1.length() == 0) {
      return true;
    }
    if (paramString1.equals(getBaseLibMajorVersion())) {
      return true;
    }
    if (mCallback != null)
    {
      paramString2 = mCallback.getLiteAppBaselibInfo(paramString1);
      paramString1 = new HostInfo();
      if (mCallback != null) {
        paramString1 = mCallback.getHostInfo();
      }
      lastPath = paramString2.path;
      if (setPath(paramString2.path, paramString1, "Vue") == 0) {
        return true;
      }
    }
    else
    {
      return false;
    }
    return false;
  }
  
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
  
  private static void onReleaseLiteApp(String paramString, long paramLong, int paramInt)
  {
    paramString = c.keQ();
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "releaseEngine %d by wechat lv.", new Object[] { Integer.valueOf(paramInt) });
    c.b localb;
    if (paramString.aidr.indexOfKey(paramInt) >= 0)
    {
      localb = (c.b)paramString.aidr.get(paramInt);
      if (localb.flutterEngine == paramString.aidp)
      {
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "default engine ignore.", new Object[0]);
        paramString.aidt = Boolean.FALSE;
      }
    }
    else
    {
      return;
    }
    paramString.aidr.remove(paramInt);
    paramString.handler.post(new c.1(paramString, localb));
  }
  
  private static void onShowPageTimeStamp(long paramLong1, long paramLong2, long paramLong3)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong1))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong1))).onShowPageTimeStamp(paramLong2, paramLong3);
    }
  }
  
  private static void onStoreSendResult(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (mCallback != null) {
      mCallback.onStoreSendResult(paramString1, paramInt, paramString2, paramString3);
    }
  }
  
  private static void onStoreSetData(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (mCallback != null) {
      mCallback.onStoreSetData(paramString, paramArrayOfString1, paramArrayOfString2);
    }
  }
  
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
  
  public static native void preloadIndexView(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public static native void preloadView(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  private static native void preloadViewBaseLib(int paramInt, String paramString);
  
  public static native int prepareCppEngineId();
  
  public static native void publishGlobalEvent(long paramLong1, long paramLong2, String paramString);
  
  public static native void publishGlobalEventToTopPage(long paramLong, String paramString1, String paramString2);
  
  public static native void release();
  
  private static void releasePage(long paramLong1, long paramLong2)
  {
    systemInfoChangeCallback.remove(Long.valueOf(paramLong2));
    pageInfos.remove(Long.valueOf(paramLong2));
  }
  
  public static native void releaseStore(String paramString);
  
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
  
  private static native void setFontScale(float paramFloat);
  
  public static native void setForceUseSyncCall(boolean paramBoolean);
  
  public static native void setLocale(String paramString1, String paramString2);
  
  private static void setPageInfo(long paramLong1, long paramLong2, PageInfo paramPageInfo)
  {
    pageInfos.put(Long.valueOf(paramLong2), paramPageInfo);
  }
  
  private static void setPageOrientation(long paramLong, int paramInt)
  {
    if (mUICallback.containsKey(Long.valueOf(paramLong))) {
      ((ILiteAppUICallback)mUICallback.get(Long.valueOf(paramLong))).setPageOrientation(paramInt);
    }
  }
  
  public static native int setPath(String paramString1, HostInfo paramHostInfo, String paramString2);
  
  public static void setPath(String paramString1, String paramString2)
  {
    lastPath = paramString1;
    HostInfo localHostInfo = new HostInfo();
    if (mCallback != null) {
      localHostInfo = mCallback.getHostInfo();
    }
    setPath(paramString1, localHostInfo, paramString2);
  }
  
  public static void setPath(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    lastPath = paramString1;
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
      setPath(paramString1, localHostInfo, paramString2);
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
  
  public static PageInfo showIndexView(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    paramString1 = innerShowIndexView(paramString1, paramString2, paramString3, paramString4, paramInt);
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
  
  public static PageInfo showView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    paramString1 = innerShowView(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt);
    pageInfos.put(Long.valueOf(paramString1.pageId), paramString1);
    pageId = paramString1.pageId;
    return paramString1;
  }
  
  public static native boolean storeIsAlive(String paramString);
  
  public static native int subscribeStore(String paramString, String[] paramArrayOfString);
  
  private static void systemInfoChange(String paramString)
  {
    Iterator localIterator = systemInfoChangeCallback.values().iterator();
    while (localIterator.hasNext())
    {
      SystemInfoChangeCallbackInfo localSystemInfoChangeCallbackInfo = (SystemInfoChangeCallbackInfo)localIterator.next();
      jsApiCallback(localSystemInfoChangeCallbackInfo.appId, localSystemInfoChangeCallbackInfo.appPtr, localSystemInfoChangeCallbackInfo.pageId, localSystemInfoChangeCallbackInfo.callbackId, paramString, true, true);
    }
  }
  
  public static native int unSubscribeStore(String paramString, String[] paramArrayOfString);
  
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
    Point localPoint = e.bf(paramContext);
    Object localObject = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    int i = localPoint.x;
    int j = localPoint.y;
    localObject = Float.valueOf(localDisplayMetrics.density);
    int k = f.be(paramContext);
    int m = f.bk(paramContext);
    float f = f.anV() * ((Float)localObject).floatValue();
    setDisplayParams(paramLong, i / ((Float)localObject).floatValue(), j / ((Float)localObject).floatValue(), localPoint.x / ((Float)localObject).floatValue(), localPoint.y / ((Float)localObject).floatValue(), localDisplayMetrics.densityDpi, ((Float)localObject).floatValue(), f / ((Float)localObject).floatValue(), k / ((Float)localObject).floatValue(), m / ((Float)localObject).floatValue());
    com.tencent.liteapp.b.b.i("WxaLiteApp.LiteAppCenter", "updateLvCppDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.densityDpi), localObject, Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) });
  }
  
  public static void updateFontScale(float paramFloat)
  {
    setFontScale(paramFloat);
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
    public abstract void closeWindow(Intent paramIntent);
    
    public abstract boolean hasCutOut();
    
    public abstract void navigateBack(boolean paramBoolean);
    
    public abstract void onCheckSumFail(String paramString, List<String> paramList);
    
    public abstract void onShowPageTimeStamp(long paramLong1, long paramLong2);
    
    public abstract void setFlags(int paramInt);
    
    public abstract void setKeepScreenOn(boolean paramBoolean);
    
    public abstract void setPageOrientation(int paramInt);
    
    public abstract void showPage(LiteAppCenter.PageInfo paramPageInfo);
    
    public abstract void vibrateLong(long paramLong);
    
    public abstract void vibrateShort(long paramLong, int paramInt);
  }
  
  public static abstract interface IWxaLiteAppCallback
  {
    public abstract void dataReporting(String paramString1, String paramString2);
    
    public abstract String[] getAppInfo(String paramString);
    
    public abstract LiteAppCenter.HostInfo getHostInfo();
    
    public abstract WxaLiteAppBaselibInfo getLiteAppBaselibInfo(String paramString);
    
    public abstract String getLiteAppRoot();
    
    public abstract String getOfflineResource(String paramString1, String paramString2, String paramString3);
    
    public abstract LiteAppCenter.SystemInfo getSystemInfo();
    
    public abstract String getUin();
    
    public abstract String getUserAgent();
    
    public abstract void hideKeyboard();
    
    public abstract void onStoreSendResult(String paramString1, int paramInt, String paramString2, String paramString3);
    
    public abstract void onStoreSetData(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);
    
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
      AppMethodBeat.i(271285);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("appid:").append(this.appId).append(" appPtr:").append(this.appPtr).append(" pageId:").append(this.pageId).append(" method:").append(this.method).append(" param:").append(this.param).append(" callback:").append(this.callbackId).append(" isFromView:").append(this.isFromView);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(271285);
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
    public int pageOrientation;
    public String pageUrl;
    public long renderId;
    public int success;
    
    static
    {
      AppMethodBeat.i(271298);
      CREATOR = new Parcelable.Creator()
      {
        public final LiteAppCenter.PageInfo createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(271287);
          paramAnonymousParcel = new LiteAppCenter.PageInfo(paramAnonymousParcel);
          AppMethodBeat.o(271287);
          return paramAnonymousParcel;
        }
        
        public final LiteAppCenter.PageInfo[] newArray(int paramAnonymousInt)
        {
          return new LiteAppCenter.PageInfo[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(271298);
    }
    
    public PageInfo(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this.success = paramInt1;
      this.appUuid = paramLong1;
      this.appPtr = paramLong2;
      this.pageId = paramLong3;
      this.renderId = paramLong4;
      this.basePath = paramString1;
      this.pageUrl = paramString2;
      this.flags = paramInt2;
      this.pageOrientation = paramInt3;
    }
    
    protected PageInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(271293);
      this.success = paramParcel.readInt();
      this.appUuid = paramParcel.readLong();
      this.appPtr = paramParcel.readLong();
      this.pageId = paramParcel.readLong();
      this.renderId = paramParcel.readLong();
      this.basePath = paramParcel.readString();
      this.pageUrl = paramParcel.readString();
      this.flags = paramParcel.readInt();
      this.pageOrientation = paramParcel.readInt();
      this.appId = paramParcel.readString();
      AppMethodBeat.o(271293);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(271306);
      String str = "PageInfo{success=" + this.success + ", uuid=" + this.appUuid + ", appPtr=" + this.appPtr + ", pageId=" + this.pageId + ", renderId=" + this.renderId + ", basePath='" + this.basePath + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", flags=" + this.flags + ", pageOrientation=" + this.pageOrientation + '}';
      AppMethodBeat.o(271306);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(271318);
      paramParcel.writeInt(this.success);
      paramParcel.writeLong(this.appUuid);
      paramParcel.writeLong(this.appPtr);
      paramParcel.writeLong(this.pageId);
      paramParcel.writeLong(this.renderId);
      paramParcel.writeString(this.basePath);
      paramParcel.writeString(this.pageUrl);
      paramParcel.writeInt(this.flags);
      paramParcel.writeInt(this.pageOrientation);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(271318);
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
      AppMethodBeat.i(271273);
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
        AppMethodBeat.o(271273);
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