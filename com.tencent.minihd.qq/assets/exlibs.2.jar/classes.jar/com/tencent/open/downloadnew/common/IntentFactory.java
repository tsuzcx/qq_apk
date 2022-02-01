package com.tencent.open.downloadnew.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class IntentFactory
{
  public static final int a = 1;
  protected static final String a = "IntentFactory";
  public static ArrayList a;
  public static final int b = 2;
  public static String b = "com.tencent.open.download.start";
  public static final int c = 3;
  public static String c = "com.tencent.open.download.pause";
  public static final int d = 4;
  public static String d = "com.tencent.open.download.restart";
  public static final int e = 5;
  public static String e = "com.tencent.open.download.complete";
  public static final int f = 6;
  public static String f = "com.tencent.open.download.open";
  public static String g = "com.tencent.open.download.yyb";
  
  static
  {
    a = new ArrayList();
    a.add(e);
    a.add(f);
    a.add(c);
    a.add(g);
    a.add(d);
    a.add(b);
  }
  
  public static PendingIntent a(int paramInt, NoticeParam paramNoticeParam)
  {
    Intent localIntent = new Intent();
    if (paramNoticeParam != null) {
      localIntent.putExtra("noticeParam", paramNoticeParam);
    }
    paramNoticeParam = Common.u();
    if (!TextUtils.isEmpty(paramNoticeParam)) {
      localIntent.putExtra("processName", paramNoticeParam);
    }
    paramNoticeParam = paramNoticeParam.replace(":", ".");
    switch (paramInt)
    {
    }
    for (;;)
    {
      return PendingIntent.getBroadcast(CommonDataAdapter.a().a(), (int)(System.currentTimeMillis() & 0xFFFFFFF), localIntent, 134217728);
      localIntent.setAction(c + "." + paramNoticeParam);
      continue;
      localIntent.setAction(b + "." + paramNoticeParam);
      continue;
      localIntent.setAction(e + "." + paramNoticeParam);
      continue;
      localIntent.setAction(g + "." + paramNoticeParam);
      continue;
      localIntent.setAction(f + "." + paramNoticeParam);
    }
  }
  
  public static Intent a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("adapter_action", "action_push_app_detail");
    localIntent.setClass(CommonDataAdapter.a().a(), QZoneAppWebViewActivity.class);
    localIntent.putExtras(paramBundle);
    Object localObject1 = new StringBuffer("sd://qapp_center_detail.htm?");
    Object localObject2 = paramBundle.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str1 = (String)((Iterator)localObject2).next();
      String str2 = paramBundle.getString(str1);
      ((StringBuffer)localObject1).append(str1).append("=").append(str2).append("&");
    }
    localObject2 = Common.a(((StringBuffer)localObject1).toString());
    localObject1 = localObject2[0];
    localObject2 = "" + localObject2[1];
    String str1 = paramBundle.getString("from");
    localIntent.putExtra("uinRestore", CommonDataAdapter.a().a());
    localIntent.putExtra("APP_URL_NOTICE", (String)localObject1);
    if (a(str1)) {}
    for (localObject1 = a(paramBundle);; localObject1 = localObject2)
    {
      localIntent.putExtra("APP_PARAMS_NOTICE", (String)localObject1);
      LogUtility.b("IntentFactory", "params=" + (String)localObject2 + "\n pushParams=" + a(paramBundle));
      if (paramBundle.containsKey("friendUin"))
      {
        localIntent.putExtra("friendUin", paramBundle.getString("friendUin"));
        localIntent.putExtra("isTroop", paramBundle.getInt("isTroop"));
      }
      localIntent.addFlags(603979776);
      return localIntent;
    }
  }
  
  public static Intent a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    Object localObject = Common.a(paramString1);
    paramString1 = (String)((HashMap)localObject).get("appid");
    String str1 = (String)((HashMap)localObject).get("sendtime");
    String str2 = (String)((HashMap)localObject).get("packname");
    String str3 = (String)((HashMap)localObject).get("packetversion");
    String str4 = (String)((HashMap)localObject).get("msgtype");
    String str5 = (String)((HashMap)localObject).get("type");
    String str6 = (String)((HashMap)localObject).get("downurl");
    localObject = (String)((HashMap)localObject).get("via");
    String str7 = AppClient.a((String)localObject);
    LogUtility.b("IntentFactory", "appid=" + paramString1 + "&sendtime=" + str1 + "&packname=" + str2 + "&packetversion=" + str3 + "&msgtype=" + str4 + "&type=" + str5 + "&downUrl=" + str6 + "&via=" + (String)localObject);
    int i = AppUtil.a(str2);
    int j = AppUtil.b(DownloadManager.a().a(paramString1));
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putString("from", "2458");
    localBundle.putString("downloadUrl", str6);
    localBundle.putString("packageName", str2);
    localBundle.putString("installedVersion", String.valueOf(i));
    localBundle.putString("localVersion", String.valueOf(j));
    localBundle.putString("serverApkVersion", str3);
    localBundle.putString("typeid", str5);
    localBundle.putString("msgType", str4);
    localBundle.putString("sendTime", str1);
    localBundle.putString("via", (String)localObject);
    localBundle.putString("splitvia", str7);
    localBundle.putString("friendUin", paramString2);
    localBundle.putInt("isTroop", paramInt);
    return a(localBundle);
  }
  
  protected static String a(Bundle paramBundle)
  {
    Object localObject1;
    if (paramBundle == null)
    {
      localObject1 = "";
      return localObject1;
    }
    String str3 = paramBundle.getString("id");
    LogUtility.b("IntentFactory", "appId=" + str3);
    String str5;
    if (!TextUtils.isEmpty(str3))
    {
      Object localObject2 = paramBundle.getString("downloadUrl");
      String str4 = paramBundle.getString("packageName");
      String str1 = paramBundle.getString("serverApkVersion");
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "0";
      }
      str5 = paramBundle.getString("via");
      String str2 = paramBundle.getString("splitvia");
      int j = AppUtil.a(str4);
      int k = AppUtil.b(DownloadManager.a().a(str3));
      if (APNUtil.c(CommonDataAdapter.a().a())) {}
      for (int i = 1;; i = 0)
      {
        try
        {
          str1 = URLEncoder.encode((String)localObject2, "utf-8");
          localObject2 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            continue;
            paramBundle = paramBundle + "&via=" + str5;
          }
        }
        paramBundle = "&from=-10&id=" + str3 + "&channelId=" + paramBundle.getString("from") + "&installedVersion=" + String.valueOf(j) + "&localVersion=" + k + "&serverApkVersion=" + (String)localObject1 + "&typeId=" + "0" + "&msgType=" + "56" + "&sendTime=" + str3 + "&downloadUrl=" + (String)localObject2 + "&packageName=" + str4 + "&nt=" + i;
        if (!TextUtils.isEmpty(str5)) {
          break label357;
        }
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        return paramBundle + "&splitvia=" + str2;
      }
    }
    label357:
    return "";
  }
  
  protected static boolean a(String paramString)
  {
    return ("2457".equals(paramString)) || ("2458".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.IntentFactory
 * JD-Core Version:    0.7.0.1
 */