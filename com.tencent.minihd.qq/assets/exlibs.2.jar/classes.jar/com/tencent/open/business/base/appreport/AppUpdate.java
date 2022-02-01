package com.tencent.open.business.base.appreport;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class AppUpdate
{
  protected static final String a = "AppUpdate";
  
  @TargetApi(11)
  protected static Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
  
  public static void a(Context paramContext, WebView paramWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    LogUtility.c("AppUpdate", "httpRequest >>> " + paramString1.toString());
    try
    {
      localObject1 = new JSONObject(paramString1);
      str1 = ((JSONObject)localObject1).optString("guid");
      str2 = ((JSONObject)localObject1).optString("url");
      str3 = ((JSONObject)localObject1).optString("method");
      str4 = ((JSONObject)localObject1).optString("oncomplate");
      str5 = ((JSONObject)localObject1).optString("onerror");
      if (((JSONObject)localObject1).optInt("supportetag", 1) != 1) {
        break label307;
      }
      i = 1;
    }
    catch (JSONException paramContext)
    {
      Object localObject1;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      Bundle localBundle;
      for (;;)
      {
        LogUtility.c("AppUpdate", "httpRequest JSONException", paramContext);
        return;
        i = 0;
        continue;
        paramString1 = "0";
      }
      if (i == 0) {
        break label340;
      }
      localBundle.putString("needhttpcache", "");
      LogUtility.c("AppUpdate", "use supportEtag");
      if (paramBoolean) {
        break label548;
      }
      paramString1 = AppUtil.a(paramContext);
      if ((paramString1 == null) || (paramString1.size() <= 0)) {
        break label548;
      }
      paramString2 = new StringBuilder();
      int i = 0;
      while (i < paramString1.size())
      {
        localObject1 = (PackageInfo)paramString1.get(i);
        paramString2.append("[\"");
        paramString2.append(((PackageInfo)localObject1).packageName);
        paramString2.append("\",");
        paramString2.append(((PackageInfo)localObject1).versionCode);
        paramString2.append(",\"");
        paramString2.append(((PackageInfo)localObject1).versionName);
        paramString2.append("\"]");
        paramString2.append(",");
        i += 1;
      }
      if (paramString2.length() <= 0) {
        break label506;
      }
      paramString2.delete(paramString2.length() - 1, paramString2.length());
      localBundle.putString("package", "[" + paramString2.toString() + "]");
      localBundle.remove("update_data");
      LogUtility.c("AppUpdate", "execute asyncTask url >>> " + str2 + " methodName " + str3);
      a(new HttpCgiAsyncTask(str2, str3, new AppUpdate.GetUpdateAppCallback(paramContext, paramWebView, str1, str4, str5, paramBoolean)), localBundle);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtility.c("AppUpdate", "httpRequest Exception", paramContext);
    }
    localBundle = new Bundle();
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("keystr", CommonDataAdapter.a().a());
    localBundle.putString("uin", paramString2);
    localBundle.putString("resolution", MobileInfoUtil.e());
    localBundle.putString("keytype", "256");
    if (AppUtil.a(paramContext))
    {
      paramString1 = "1";
      localBundle.putString("allowScan", paramString1);
      if (!str3.equals("POST")) {
        break label319;
      }
      paramString1 = ((JSONObject)localObject1).optJSONObject("params");
      if (paramString1 == null) {
        break label340;
      }
      paramString2 = paramString1.keys();
      while (paramString2.hasNext())
      {
        localObject1 = paramString2.next().toString();
        Object localObject2 = paramString1.get((String)localObject1);
        LogUtility.c("AppUpdate", "key = " + (String)localObject1 + " value = " + localObject2.toString());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localBundle.putString((String)localObject1, localObject2.toString());
        }
      }
    }
    label307:
    label319:
    label340:
    label506:
    return;
  }
  
  @TargetApi(11)
  protected static void a(HttpCgiAsyncTask paramHttpCgiAsyncTask, Bundle paramBundle)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      paramHttpCgiAsyncTask.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    paramHttpCgiAsyncTask.execute(new Bundle[] { paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppUpdate
 * JD-Core Version:    0.7.0.1
 */