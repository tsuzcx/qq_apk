package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import leb;
import lec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInterface
  extends BaseInterface
  implements IJsCallBack
{
  public final String TAG = DownloadInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  LastDownloadAction lastActionRecord = null;
  protected UpdateManager.OnCheckUpdateListener listener;
  protected Activity mActivity;
  protected Handler mHandler;
  public final WebView webview;
  
  public DownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    LogUtility.c(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    paramActivity = localObject;
    if ((this.mActivity instanceof BaseActivity)) {
      paramActivity = (AppInterface)((BaseActivity)this.mActivity).getAppRuntime();
    }
    DownloadManager.a().a(paramActivity);
    JsCallbackManager.a().a(this);
    LogUtility.c(this.TAG, "init out");
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      bool = false;
    }
    while (paramInt != 1) {
      return bool;
    }
    return true;
  }
  
  private void innerQueryDownloadInfo(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int j = paramJSONArray.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.b = localJSONObject.optString("appid");
        localDownloadInfo.i = localJSONObject.optString("myAppId");
        localDownloadInfo.j = localJSONObject.optString("apkId");
        localDownloadInfo.d = localJSONObject.optString("packageName");
        localDownloadInfo.g = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a(localArrayList, new leb(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      LogUtility.c(this.TAG, "innerQueryDownloadInfo>>>", paramJSONArray);
    }
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    DownloadApi.a(paramString1, paramString2, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadManager.a().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    LogUtility.c(this.TAG, "enter checkUpdate json=" + paramString1 + ", guid = " + paramString2);
    if (!hasRight()) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = ((JSONObject)localObject).optString("guid");
        }
        paramString2 = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("packageNames");
        if (localObject != null)
        {
          int i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString2.add(((JSONArray)localObject).getString(i));
            i += 1;
            continue;
          }
        }
        if (this.listener == null)
        {
          this.listener = new DownloadInterface.JsCheckUpdateCallback(this, paramString1);
          UpdateManager.a().a(this.listener);
          UpdateManager.a().a(paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        LogUtility.c(this.TAG, "httpRequest JSONException", paramString1);
        return;
      }
      ((DownloadInterface.JsCheckUpdateCallback)this.listener).b(paramString1);
    }
  }
  
  public void destroy()
  {
    LogUtility.c(this.TAG, "destroy");
    JsCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.a().b(this.listener);
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localJSONObject = new JSONObject(paramString);
      localBundle.putString(DownloadConstants.a, localJSONObject.optString("appid"));
      localBundle.putString(DownloadConstants.i, localJSONObject.optString("url"));
      localBundle.putString(DownloadConstants.e, localJSONObject.optString("packageName"));
      localBundle.putInt(DownloadConstants.j, localJSONObject.optInt("actionCode"));
      localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
      localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
      localBundle.putBoolean(DownloadConstants.q, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(DownloadConstants.o, localJSONObject.optString("wording"));
      paramString = localJSONObject.optString(DownloadConstants.A);
      LogUtility.d(this.TAG, " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label790;
      }
      if (!paramString.startsWith("0;")) {
        break label663;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      Object localObject;
      int i;
      boolean bool;
      LogUtility.c(this.TAG, "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        LogUtility.c(this.TAG, "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    LogUtility.d(this.TAG, " finalFeedChannel:" + paramString);
    localBundle.putString(DownloadConstants.A, paramString);
    paramString = localJSONObject.optString("via");
    localObject = localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    if (this.lastActionRecord == null)
    {
      this.lastActionRecord = new LastDownloadAction((String)localObject, paramString, i);
      label306:
      if (localJSONObject.optInt("actionCode") == 12)
      {
        bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(DownloadConstants.n, bool);
        bool = localJSONObject.has("updateData");
        if (!bool) {}
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          localObject = localJSONObject.optString("updateData");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramString = new ApkUpdateDetail();
        }
        catch (Exception paramString)
        {
          int j;
          label663:
          paramString = null;
          continue;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          paramString.packageName = ((JSONObject)localObject).optString("packageName");
          paramString.newapksize = ((JSONObject)localObject).optInt("newapksize");
          paramString.patchsize = ((JSONObject)localObject).optInt("patchsize");
          paramString.updatemethod = ((JSONObject)localObject).optInt("updatemethod");
          paramString.versioncode = ((JSONObject)localObject).optInt("versioncode");
          paramString.versionname = ((JSONObject)localObject).optString("versionname");
          paramString.fileMd5 = ((JSONObject)localObject).optString("fileMd5");
          paramString.sigMd5 = ((JSONObject)localObject).optString("sigMd5");
          paramString.url = ((JSONObject)localObject).optString("url");
          i = localJSONObject.optInt("myAppConfig");
          localBundle.putString(DownloadConstants.b, localJSONObject.optString("myAppId"));
          localBundle.putString(DownloadConstants.c, localJSONObject.optString("apkId"));
          localBundle.putInt(DownloadConstants.d, localJSONObject.optInt("versionCode"));
          localBundle.putInt(DownloadConstants.m, localJSONObject.optInt("toPageType"));
          localBundle.putBoolean(DownloadConstants.f, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
          localBundle.putBoolean(DownloadConstants.g, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
          j = localJSONObject.optInt("sourceType");
          LogUtility.c(this.TAG, "doDownloadAction object " + localJSONObject.toString());
          DownloadApi.a(this.mActivity, localBundle, j, paramString, i);
          return 0;
        }
        catch (Exception localException)
        {
          continue;
        }
        paramString = paramString.split(";");
        if (paramString == null)
        {
          paramString = "";
          break;
        }
        if (paramString.length <= 0)
        {
          paramString = "";
          break;
        }
        localObject = paramString[0];
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramString = (String)localObject;
        if (!((String)localObject).equals("0")) {
          break;
        }
        continue;
        if (!this.lastActionRecord.a((String)localObject, paramString, i)) {
          break label306;
        }
        return 0;
        LogUtility.c(this.TAG, "enter doDownloadAction updateData json");
      }
    }
  }
  
  public void doGCDownloadAction(String paramString)
  {
    doDownloadAction(paramString);
  }
  
  public void doWifiDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      LogUtility.c(this.TAG, "doDownloadAction object " + paramString.toString());
      paramString = paramString.optString("via");
      MyAppApi.a().b(this.mActivity, paramString, 0);
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c(this.TAG, "doWifiDownloadAction>>>", paramString);
    }
  }
  
  public String getDownloadVersion()
  {
    return DownloadApi.a() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      innerQueryDownloadInfo(paramString.getJSONArray("infolist"), paramString.getString("guid"));
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c(this.TAG, "query>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    try
    {
      innerQueryDownloadInfo(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.TAG, "query>>>", paramString1);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void installYYB()
  {
    MyAppApi.a().c(this.mActivity);
  }
  
  public void jsCallBack(String paramString)
  {
    this.mHandler.post(new lec(this, paramString));
  }
  
  public int openDownloaderWebview(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      DownloadApi.a(this.mActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        LogUtility.c(this.TAG, "JSONException", paramString);
      }
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    LogUtility.c(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  public int setDownloaderFirstOpenPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      DownloadApi.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        LogUtility.c(this.TAG, "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface
 * JD-Core Version:    0.7.0.1
 */