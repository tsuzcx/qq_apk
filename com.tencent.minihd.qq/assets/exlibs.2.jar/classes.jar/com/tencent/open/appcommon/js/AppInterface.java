package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.business.base.appreport.AppUpdate;
import com.tencent.open.downloadnew.MyAppDialog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ldp;
import ldr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppInterface
  extends BaseInterface
{
  protected static final String APP_UPDATE_TAG = "AppUpdate";
  public Activity activity;
  public Handler mHandler;
  public MyAppDialog tipDialog;
  public WebView webView;
  
  public AppInterface(Activity paramActivity, WebView paramWebView)
  {
    this.activity = paramActivity;
    this.webView = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public String gSetPackageScanSetting(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return null;
      if (paramString1.equals("2"))
      {
        if (AppUtil.a(this.activity)) {
          return "1";
        }
        return "0";
      }
      if (paramString1.equals("0"))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
        paramString1 = new ldp(this, paramString2);
        this.mHandler.post(new ldr(this, paramString1));
        return null;
      }
    } while (!paramString1.equals("1"));
    paramString1 = CommonDataAdapter.a().a().getSharedPreferences("package_scan", 0).edit();
    paramString1.putBoolean("qqsetting_package_scan_flag", true);
    paramString1.commit();
    return "1";
  }
  
  public String getAllDownAppInfo(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    JSONArray localJSONArray = new JSONArray();
    List localList = AppUtil.a(this.activity);
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        PackageInfo localPackageInfo = (PackageInfo)localList.get(i);
        if ((localPackageInfo.applicationInfo.flags & 0x1) == 0) {
          localJSONArray.put(getAppInfo(localPackageInfo, paramString1, paramString2, paramString3));
        }
        i += 1;
      }
      return localJSONArray.toString();
    }
    return "[]";
  }
  
  public String getAppInfo(String paramString)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return getAppInfo(paramString, "true", "true", "true");
  }
  
  public String getAppInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (!hasRight()) {
        return "baby,you don't have permission";
      }
      if (StringAddition.a(paramString1)) {
        return "[]";
      }
      paramString1 = this.activity.getPackageManager().getPackageInfo(paramString1, 0);
      if (paramString1 == null) {
        return "[]";
      }
      paramString1 = getAppInfo(paramString1, paramString2, paramString3, paramString4).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "[]";
  }
  
  protected JSONArray getAppInfo(PackageInfo paramPackageInfo, String paramString1, String paramString2, String paramString3)
  {
    int i;
    int j;
    label24:
    int k;
    if ("true".equals(paramString1))
    {
      i = 1;
      if (!"true".equals(paramString2)) {
        break label179;
      }
      j = 1;
      if (!"true".equals(paramString3)) {
        break label196;
      }
      k = 1;
      label37:
      paramString1 = new JSONArray();
      paramString1.put(paramPackageInfo.packageName);
      paramString1.put(paramPackageInfo.versionCode);
      paramString1.put(paramPackageInfo.versionName);
      if (i == 0) {
        break label214;
      }
      paramString1.put(paramPackageInfo.applicationInfo.loadLabel(this.activity.getPackageManager()).toString());
      label101:
      if (j == 0) {
        break label224;
      }
      paramString1.put(ImageUtil.a(paramPackageInfo.applicationInfo.loadIcon(this.activity.getPackageManager())));
      label128:
      if (k == 0) {
        break label252;
      }
      if (Build.VERSION.SDK_INT <= 7) {
        break label243;
      }
      if ((paramPackageInfo.applicationInfo.flags & 0x40000) == 0) {
        break label234;
      }
      paramString1.put(1);
    }
    for (;;)
    {
      return paramString1;
      if ("false".equals(paramString1))
      {
        i = 0;
        break;
      }
      return null;
      label179:
      if ("false".equals(paramString2))
      {
        j = 0;
        break label24;
      }
      return null;
      label196:
      if ("false".equals(paramString3))
      {
        k = 0;
        break label37;
      }
      return null;
      label214:
      paramString1.put("");
      break label101;
      label224:
      paramString1.put("");
      break label128;
      label234:
      paramString1.put(0);
      continue;
      label243:
      paramString1.put(0);
      continue;
      label252:
      paramString1.put(-1);
    }
  }
  
  public String getAppInfoBatch(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    if (StringAddition.a(paramString1)) {
      return "{}";
    }
    paramString2 = StringAddition.a(paramString1, paramString2);
    if (paramString2.length == 0) {
      return "{}";
    }
    paramString1 = new LinkedHashMap();
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramString2[i];
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        paramString1.put(localObject, "");
      }
      i += 1;
    }
    paramString2 = new JSONArray();
    Object localObject = AppUtil.a(this.activity);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if (paramString1.containsKey(localPackageInfo.packageName)) {
          paramString2.put(getAppInfo(localPackageInfo, paramString3, paramString4, paramString5));
        }
      }
    }
    return paramString2.toString();
  }
  
  public String getInterfaceName()
  {
    return "qzone_app";
  }
  
  protected String getRecentApp(int paramInt)
  {
    Object localObject1 = (ActivityManager)this.activity.getSystemService("activity");
    PackageManager localPackageManager = this.activity.getPackageManager();
    int j = paramInt;
    if (paramInt <= 0) {
      j = 5;
    }
    List localList = ((ActivityManager)localObject1).getRecentTasks(64, 1);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int n;
    int k;
    Object localObject3;
    if (localList != null)
    {
      n = localList.size();
      k = 0;
      paramInt = 0;
      if ((k < n) && (paramInt < j))
      {
        localObject3 = (ActivityManager.RecentTaskInfo)localList.get(k);
        localObject1 = ((ActivityManager.RecentTaskInfo)localObject3).baseIntent;
        localObject3 = ((ActivityManager.RecentTaskInfo)localObject3).origActivity;
        if (localObject3 != null) {
          localObject1 = ((ComponentName)localObject3).getPackageName();
        }
      }
    }
    for (;;)
    {
      label140:
      int i = paramInt;
      if (localObject1 != null)
      {
        if (localArrayList.contains(localObject1)) {}
        for (;;)
        {
          k += 1;
          break;
          if (localObject1 == null) {
            break label413;
          }
          localObject1 = ((Intent)localObject1).getComponent().getPackageName();
          break label140;
          localArrayList.add(localObject1);
          i = -1;
          try
          {
            localObject3 = localPackageManager.getPackageInfo((String)localObject1, 0);
            if (localObject3 != null) {
              break label222;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localNameNotFoundException.printStackTrace();
          }
        }
        label222:
        if (localObject3 != null)
        {
          i = ((PackageInfo)localObject3).versionCode;
          String str = ((PackageInfo)localObject3).versionName;
        }
        if ((((PackageInfo)localObject3).applicationInfo.flags & 0x1) == 0) {
          break label407;
        }
      }
      label407:
      for (int m = 1;; m = 0)
      {
        paramInt += 1;
        localStringBuilder.append("\"");
        localStringBuilder.append(localNameNotFoundException);
        localStringBuilder.append("\"");
        localStringBuilder.append(":");
        localStringBuilder.append("\"");
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        localStringBuilder.append(m);
        localStringBuilder.append("\"");
        i = paramInt;
        if (k < n - 1)
        {
          localStringBuilder.append(",");
          i = paramInt;
        }
        paramInt = i;
        break;
        paramInt = localStringBuilder.length();
        if (localStringBuilder.charAt(paramInt - 1) == ',') {
          localStringBuilder.deleteCharAt(paramInt - 1);
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      label413:
      Object localObject2 = null;
    }
  }
  
  public void getUpdateApp(String paramString)
  {
    LogUtility.b("AppUpdate", "getUpdateApp , param = " + paramString);
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("imei", MobileInfoUtil.c());
      localJSONObject2.put("imsi", MobileInfoUtil.d());
      localJSONObject2.put("mac_addr", MobileInfoUtil.a());
      localJSONObject2.put("model_info", Build.MODEL);
      localJSONObject2.put("network_type", APNUtil.a(CommonDataAdapter.a().a()));
      localJSONObject2.put("network_operater", "");
      localJSONObject2.put("location", MobileInfoUtil.f());
      localJSONObject2.put("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
      localJSONObject2.put("os_api_level", Build.VERSION.SDK_INT);
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("params");
      if ((localJSONObject3 != null) && (localJSONObject3.length() > 0))
      {
        Iterator localIterator = localJSONObject3.keys();
        while (localIterator.hasNext())
        {
          String str2 = localIterator.next().toString();
          Object localObject = localJSONObject3.get(str2);
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject2.put(str2, localObject);
          }
        }
      }
      String str1;
      return;
    }
    catch (JSONException localJSONException)
    {
      LogUtility.e("AppUpdate", "getUpdateApp parse H5 params error : " + localJSONException.toString());
      if (!this.activity.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
      {
        LogUtility.c("AppUpdate", "getUpdateApp will do full report");
        AppReport.a(this.activity, paramString, this.webView, String.valueOf(CommonDataAdapter.a().a()));
        return;
        if (localJSONObject3 != null) {
          localJSONObject2.put("latest_used", getRecentApp(localJSONObject3.optInt("latest_num", 5)));
        }
        for (;;)
        {
          localJSONException.put("params", localJSONObject2);
          str1 = localJSONException.toString();
          paramString = str1;
          break;
          localJSONObject2.put("latest_used", getRecentApp(5));
        }
      }
      if (new File(this.activity.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
      {
        LogUtility.c("AppUpdate", "getUpdateApp will do incremental report");
        AppReport.a(this.activity, null, 0, paramString, this.webView, String.valueOf(CommonDataAdapter.a().a()));
        return;
      }
      LogUtility.c("AppUpdate", "getUpdateApp will get update app directly");
      AppUpdate.a(this.activity, this.webView, paramString, true, String.valueOf(CommonDataAdapter.a().a()));
    }
  }
  
  public int uninstallApp(String paramString)
  {
    if (!hasRight()) {}
    while (!AppUtil.b(this.activity, paramString)) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface
 * JD-Core Version:    0.7.0.1
 */