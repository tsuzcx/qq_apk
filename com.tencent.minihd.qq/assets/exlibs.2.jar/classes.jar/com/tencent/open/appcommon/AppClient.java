package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppCenterActivity;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import ldg;
import ldh;
import ldi;
import mqq.util.WeakReference;

public class AppClient
{
  protected static final int a = 1;
  public static final String a = AppClient.class.getSimpleName();
  public static WeakReference a;
  protected static final int b = 2;
  protected static final String b = "https://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi";
  protected static final int c = 3;
  protected static final String c = "100_1";
  protected static final int d = 7;
  protected static final String d = "200_1";
  protected static final int e = 8;
  protected static final String e = "200_2";
  public static final int f = 1;
  protected static final String f = "2410";
  public static final int g = 2;
  public static final String g = "2457";
  public static final int h = 3;
  public static final String h = "2458";
  public static final String i = "2460";
  public static final String j = "detail";
  public static final String k = "custom";
  public static final String l = "online";
  public static final String m = "feedlist";
  public static final String n = "index";
  public static final String o = "tmast";
  public static final String p = "auto_download";
  public static final String q = "1";
  protected static final String r = "https://appic.qq.com/cgi-bin/appstage/get_apk_info";
  
  public static Class a(String paramString)
  {
    if (paramString.equals("detail")) {
      return QZoneAppWebViewActivity.class;
    }
    if (paramString.equals("feedlist")) {
      return QZoneAppCenterActivity.class;
    }
    if (paramString.equals("index")) {
      return QZoneAppListActivity.class;
    }
    if (paramString.equals("online")) {}
    return QZoneAppWebViewActivity.class;
  }
  
  protected static String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    LogUtility.c(a, "getFeedsChannelId >>> qzoneAppid = " + paramInt1 + "| " + paramInt2 + " | " + paramInt3);
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "100_1";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "200_1";
      }
      if (paramInt3 == 1) {
        return "200_2";
      }
      break;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("\\.");
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 2;
    if ((paramString != null) && (paramString.length > 2))
    {
      if (i1 < paramString.length)
      {
        if (i1 == paramString.length - 1) {
          localStringBuilder.append(paramString[i1]);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localStringBuilder.append(paramString[i1] + ".");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Common.a();
    int i1 = paramBundle.getInt("qzoneAppid");
    int i2 = paramBundle.getInt("qzoneSubId");
    int i3 = paramBundle.getInt("op_type");
    int i4 = paramBundle.getInt("from");
    paramActivity = paramBundle.getString("schemaUrl");
    Object localObject1;
    if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains("&")))
    {
      localObject5 = new Bundle();
      if (paramActivity.startsWith("http://")) {}
      String str3;
      String str2;
      for (;;)
      {
        try
        {
          localObject1 = new URL(paramActivity).getQuery();
          HashMap localHashMap = Common.a((String)localObject1);
          str1 = (String)localHashMap.get("appid");
          if (TextUtils.isEmpty(str1))
          {
            str1 = (String)localHashMap.get(DownloadConstants.a);
            localObject3 = (String)localHashMap.get(DownloadConstants.b);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label409;
            }
            localObject3 = (String)localHashMap.get("ta");
            localObject4 = (String)localHashMap.get(DownloadConstants.c);
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label412;
            }
            localObject4 = (String)localHashMap.get("tk");
            str3 = (String)localHashMap.get(DownloadConstants.d);
            str2 = (String)localHashMap.get("via");
            localObject2 = (String)localHashMap.get("packName");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label415;
            }
            localObject2 = (String)localHashMap.get(DownloadConstants.e);
            paramActivity = (String)localHashMap.get(DownloadConstants.A);
            LogUtility.d(a, " feedChannel:" + paramActivity + "   schemaUrl:" + (String)localObject1);
            if ((!TextUtils.isEmpty(paramActivity)) && (!paramActivity.startsWith("0;"))) {
              break label418;
            }
            paramActivity = "";
            LogUtility.d(a, " finalFeedChannel:" + paramActivity);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!AppUtil.a((String)localObject2))) {
              break;
            }
            paramActivity = (String)localHashMap.get("appCustom");
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          String str1;
          localMalformedURLException.printStackTrace();
        }
        try
        {
          paramBundle = URLDecoder.decode(paramActivity, "UTF-8");
          paramActivity = paramBundle;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            CharSequence localCharSequence;
            Activity localActivity;
            break;
          }
        }
        AppUtil.a(CommonDataAdapter.a().a(), str1, (String)localObject2, paramActivity);
        return;
        localObject1 = paramActivity;
        continue;
        continue;
        label409:
        continue;
        label412:
        continue;
        label415:
        continue;
        label418:
        paramActivity = paramActivity.split(";");
        if (paramActivity == null)
        {
          paramActivity = "";
        }
        else if (paramActivity.length <= 0)
        {
          paramActivity = "";
        }
        else
        {
          localCharSequence = paramActivity[0];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            paramActivity = localCharSequence;
            if (!localCharSequence.equals("0")) {}
          }
          else
          {
            paramActivity = "";
          }
        }
      }
      ((Bundle)localObject5).putString(DownloadConstants.a, localMalformedURLException);
      ((Bundle)localObject5).putString(DownloadConstants.b, (String)localObject3);
      ((Bundle)localObject5).putString(DownloadConstants.c, (String)localObject4);
      ((Bundle)localObject5).putString(DownloadConstants.d, str3);
      ((Bundle)localObject5).putString(DownloadConstants.e, (String)localObject2);
      ((Bundle)localObject5).putString(DownloadConstants.h, str2);
      ((Bundle)localObject5).putString(DownloadConstants.A, paramActivity);
      ((Bundle)localObject5).putString("schemaUrl", (String)localObject1);
      paramActivity = (Activity)localObject5;
      localObject4 = str3;
      localObject3 = localObject2;
      localObject2 = paramActivity;
      paramActivity = str2;
      if (i3 != 7) {
        break label718;
      }
      localObject5 = a(i1, i2, i4, localMalformedURLException);
      if (!TextUtils.isEmpty(paramActivity)) {
        break label1165;
      }
      paramActivity = StaticAnalyz.a(i1, i2, i4);
      OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().a()), localMalformedURLException, paramActivity, "200", false);
    }
    label718:
    for (paramActivity = (Activity)localObject5;; paramActivity = "2410")
    {
      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3)) || ("0".equals(localObject4)) || (localObject2 == null) || (!MyAppApi.a().c())) {
        break label724;
      }
      ThreadManager.b().post(new ldh(paramBundle, (Bundle)localObject2, localMalformedURLException, paramActivity, (String)localObject1));
      return;
      localObject2 = null;
      localObject3 = null;
      localObject4 = "0";
      localObject1 = paramActivity;
      localActivity = paramActivity;
      paramActivity = null;
      break;
    }
    label724:
    Object localObject2 = Common.i() + File.separator + "qapp_center_detail.htm";
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists())
    {
      LogUtility.d(a, "file" + (String)localObject2 + " not exist copyassets.");
      FileUtils.a("Page/system", Common.j());
    }
    Object localObject4 = new Intent();
    Object localObject5 = new Bundle();
    if (((File)localObject3).exists())
    {
      localObject2 = "file:///" + (String)localObject2;
      localObject3 = "&from=-10&id=" + localActivity + "&channelId=" + paramActivity;
      paramActivity = (Activity)localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!((String)localObject1).equals(localActivity)) {
          break label1127;
        }
        paramActivity = (Activity)localObject3;
      }
      label921:
      if (Common.a(paramBundle.getString("schemaUrl")).get("auto_download") == null) {
        break label1156;
      }
    }
    label1156:
    for (i1 = 1;; i1 = 0)
    {
      paramBundle = paramActivity;
      if (i1 != 0) {
        paramBundle = paramActivity + "&auto_download=1";
      }
      ((Intent)localObject4).setClass(CommonDataAdapter.a().a(), QZoneAppWebViewActivity.class);
      ((Bundle)localObject5).putString("APP_URL", (String)localObject2);
      ((Bundle)localObject5).putBoolean("FROM_FEED", true);
      ((Bundle)localObject5).putString("APP_PARAMS", paramBundle);
      LogUtility.b("Jie", "APP_URL:" + (String)localObject2 + " |  PARAMS >>> " + ((Bundle)localObject5).getString("APP_PARAMS"));
      ((Intent)localObject4).putExtras((Bundle)localObject5);
      ((Intent)localObject4).putExtra("adapter_action", "action_app_detail");
      ((Intent)localObject4).addFlags(872415232);
      CommonDataAdapter.a().a().startActivity((Intent)localObject4);
      return;
      localObject2 = Common.p() + File.separator + "qapp_center_detail.htm";
      break;
      label1127:
      paramActivity = (String)localObject3 + "&" + (String)localObject1;
      break label921;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    a(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    localBundle.putInt("qzoneAppid", paramInt1);
    localBundle.putInt("qzoneSubId", paramInt2);
    localBundle.putInt("from", paramInt3);
    a(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    String str1 = Common.i() + File.separator + "qapp_center_detail.htm";
    Common.a();
    Object localObject = new File(str1);
    if (!((File)localObject).exists())
    {
      LogUtility.d(a, "file" + str1 + " not exist copyassets.");
      FileUtils.a("Page/system", Common.j());
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    String str2;
    if (((File)localObject).exists())
    {
      str2 = "file:///" + str1;
      localIntent.setClass(paramActivity, QZoneAppWebViewActivity.class);
      str1 = "&from=-10&id=" + paramString + "&channelId=" + paramInt;
      paramString = null;
      if (paramBundle != null) {
        paramString = paramBundle.getString("via");
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label533;
      }
    }
    for (;;)
    {
      int i1 = 0;
      paramString = str1;
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("autoDownload");
        paramString = paramBundle.getString("packageName");
        localObject = str1;
        if (!TextUtils.isEmpty(paramString)) {
          localObject = str1 + "&packageName=" + paramString;
        }
        str1 = paramBundle.getString("subpagetype");
        paramString = (String)localObject;
        i1 = bool;
        if (!TextUtils.isEmpty(str1))
        {
          paramString = (String)localObject + "&subpagetype=" + str1;
          i1 = bool;
        }
      }
      str1 = paramString;
      if (i1 != 0) {
        str1 = paramString + "&msgType=56";
      }
      localBundle.putString("APP_PARAMS", str1);
      if (paramBundle != null)
      {
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
      }
      localBundle.putString("APP_URL", str2);
      localBundle.putBoolean("FROM_FEED", true);
      LogUtility.b("Jie", "APP_URL:" + str2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(603979776);
      paramActivity.startActivityForResult(localIntent, 200);
      return;
      str2 = Common.p() + File.separator + "qapp_center_detail.htm";
      break;
      label533:
      str1 = str1 + "&via=" + paramString;
    }
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4)
  {
    Common.a();
    int i1 = 1;
    Object localObject;
    Intent localIntent;
    Bundle localBundle;
    Class localClass;
    String str5;
    String str1;
    String str4;
    String str6;
    String str3;
    if (!paramString3.equals("online"))
    {
      paramString4 = Common.i() + File.separator + paramString4;
      localObject = new File(paramString4);
      if (!((File)localObject).exists())
      {
        LogUtility.d(a, "file" + paramString4 + " not exist copyassets.");
        FileUtils.a("Page/system", Common.j());
      }
      if (((File)localObject).exists())
      {
        paramString4 = "file:///" + paramString4;
        localIntent = new Intent();
        localBundle = new Bundle();
        localClass = a(paramString3);
        localIntent.setClass(paramActivity, localClass);
        str5 = paramBundle.getString("installedVersion");
        String str7 = paramBundle.getString("localVersion");
        String str8 = paramBundle.getString("typeid");
        String str9 = paramBundle.getString("serverApkVersion");
        String str10 = paramBundle.getString("msgType");
        String str2 = paramBundle.getString("sendTime");
        str1 = paramBundle.getString("via");
        str4 = paramBundle.getString("splitvia");
        str6 = paramBundle.getString("subPageType");
        str3 = paramBundle.getString("appCustom");
        localObject = paramString2;
        if (paramString2 == "2460") {
          localObject = paramString2 + "_" + str10;
        }
        paramString2 = "&from=-10&id=" + paramString1 + "&channelId=" + (String)localObject + "&installedVersion=" + str5 + "&localVersion=" + str7 + "&serverApkVersion=" + str9 + "&typeId=" + str8 + "&msgType=" + str10 + "&sendTime=" + str2;
        str5 = paramBundle.getString("schemaUrl");
        if (!TextUtils.isEmpty(str6)) {
          break label1007;
        }
        label409:
        if (!TextUtils.isEmpty(str1)) {
          break label1036;
        }
        label417:
        if (!TextUtils.isEmpty(str4)) {
          break label1065;
        }
        label425:
        if (!TextUtils.isEmpty(str3)) {
          break label1094;
        }
        label433:
        if (!TextUtils.isEmpty(str5)) {
          break label1123;
        }
        label441:
        localBundle.putString("APP_PARAMS", paramString2);
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
        localBundle.putString("APP_URL", paramString4);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString(DownloadConstants.h, str1);
        if (localClass.getName().equals(QZoneAppCenterActivity.class.getName()))
        {
          LogUtility.e(a, "targetClass == QZoneAppCenterActivity");
          localBundle.putString("sendTime", str2);
          localBundle.putString("autoType", "57");
          localBundle.putString("channelId", (String)localObject);
          localBundle.putString("appid", paramString1);
          localBundle.putLong("uinRestore", CommonDataAdapter.a().a());
          localBundle.putBoolean("scheme", true);
          localBundle.putString("source", "app");
        }
        if ((!paramString3.equals("custom")) || (i1 == 0)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = paramBundle.getString("pageTitles");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = new ArrayList(Arrays.asList(paramString2.split("&")));
          localBundle.putStringArrayList("titleName", paramString2);
          if (paramString2.size() <= 0) {
            continue;
          }
          bool = true;
          localBundle.putBoolean("showTitle", bool);
          LogUtility.b(a, "titles = " + paramString2);
        }
      }
      catch (Exception paramString2)
      {
        boolean bool;
        label1007:
        LogUtility.c(a, "get push title error>>>", paramString2);
        label1036:
        label1065:
        label1094:
        label1123:
        continue;
        paramActivity.startActivityForResult(localIntent, 200);
        return;
      }
      LogUtility.b("TAG", "APP_URL:" + paramString4 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(603979776);
      if (!localClass.getName().equals(QZoneAppWebViewActivity.class.getName())) {
        break label1205;
      }
      if (!((String)localObject).equals("2457")) {
        break label1181;
      }
      paramString1 = DownloadManager.a().a(paramString1);
      if ((!MyAppApi.a().c()) || (paramString1 == null) || (paramString1.h != 1)) {
        continue;
      }
      LogUtility.d(a, ">>>appid=" + paramString1.b + " myAppid=" + paramString1.i);
      localBundle.putString(DownloadConstants.a, paramString1.b);
      localBundle.putString(DownloadConstants.b, paramString1.i);
      localBundle.putString(DownloadConstants.c, paramString1.j);
      localBundle.putString(DownloadConstants.h, str1);
      localBundle.putString(DownloadConstants.e, paramString1.d);
      localBundle.putInt(DownloadConstants.d, paramString1.g);
      MyAppApi.a().a(paramActivity, localBundle, ((String)localObject).equals("2457"), true);
      return;
      i1 = 0;
      paramString4 = Common.p() + File.separator + "qapp_center_detail.htm";
      break;
      break;
      paramString2 = paramString2 + "&subPageType=" + str6;
      break label409;
      paramString2 = paramString2 + "&via=" + str1;
      break label417;
      paramString2 = paramString2 + "&splitVia=" + str4;
      break label425;
      paramString2 = paramString2 + "&appCustom=" + str3;
      break label433;
      paramString2 = paramString2 + "&" + str5;
      break label441;
      bool = false;
    }
    label1181:
    ThreadManager.b().post(new ldg(paramString1, localBundle, str1, paramActivity, localIntent, paramBundle));
    return;
    label1205:
    paramActivity.startActivityForResult(localIntent, 200);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2457");
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LogUtility.b(a, "shcemaUrlAnd:" + paramString1);
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = Common.a(paramString1);
      String str8 = (String)((HashMap)localObject2).get("appid");
      String str10 = (String)((HashMap)localObject2).get("sendtime");
      String str9 = (String)((HashMap)localObject2).get("packname");
      String str13 = (String)((HashMap)localObject2).get("packetversion");
      String str11 = (String)((HashMap)localObject2).get("msgtype");
      String str14 = (String)((HashMap)localObject2).get("type");
      Object localObject1 = (String)((HashMap)localObject2).get("downurl");
      String str12 = (String)((HashMap)localObject2).get("via");
      String str15 = a(str12);
      String str7 = (String)((HashMap)localObject2).get("appCustom");
      String str2 = (String)((HashMap)localObject2).get("nativepage");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = (String)((HashMap)localObject2).get("np");
      }
      str2 = (String)((HashMap)localObject2).get("htmlpage");
      label237:
      label371:
      String str16;
      label271:
      label305:
      label338:
      int i1;
      if (TextUtils.isEmpty(str2))
      {
        str2 = (String)((HashMap)localObject2).get("hp");
        String str3 = (String)((HashMap)localObject2).get("subpagetype");
        if (!TextUtils.isEmpty(str3)) {
          break label865;
        }
        str3 = (String)((HashMap)localObject2).get("sp");
        String str4 = (String)((HashMap)localObject2).get("pagetitles");
        if (!TextUtils.isEmpty(str4)) {
          break label868;
        }
        str4 = (String)((HashMap)localObject2).get("pt");
        String str5 = (String)((HashMap)localObject2).get(DownloadConstants.b);
        if (!TextUtils.isEmpty(str5)) {
          break label871;
        }
        str5 = (String)((HashMap)localObject2).get("ta");
        String str6 = (String)((HashMap)localObject2).get(DownloadConstants.c);
        if (!TextUtils.isEmpty(str6)) {
          break label874;
        }
        str6 = (String)((HashMap)localObject2).get("tk");
        str16 = (String)((HashMap)localObject2).get("minvercode");
        localObject2 = (String)((HashMap)localObject2).get("backurl");
        LogUtility.b(a, "appid=" + str8 + " ,sendtime=" + str10 + " ,packname=" + str9 + " ,packetversion=" + str13 + " ,msgtype=" + str11 + " ,type=" + str14 + " ,downUrl=" + (String)localObject1 + " ,nativePage=" + str1 + " ,htmlPage=" + str2 + " ,subPageType=" + str3 + " ,pageTitles=" + str4 + " ,minvercode=" + str16 + " ,backUrl=" + (String)localObject2);
        i1 = AppUtil.a(str9);
        int i2 = AppUtil.b(DownloadManager.a().a(str8));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("installedVersion", String.valueOf(i1));
        ((Bundle)localObject1).putString("localVersion", String.valueOf(i2));
        ((Bundle)localObject1).putString("serverApkVersion", str13);
        ((Bundle)localObject1).putString("typeid", str14);
        ((Bundle)localObject1).putString("msgType", str11);
        ((Bundle)localObject1).putString("sendTime", str10);
        ((Bundle)localObject1).putString("subPageType", str3);
        ((Bundle)localObject1).putString("pageTitles", str4);
        ((Bundle)localObject1).putString("appCustom", str7);
        ((Bundle)localObject1).putString("schemaUrl", paramString1);
        if (!TextUtils.isEmpty(str12))
        {
          ((Bundle)localObject1).putString("via", str12);
          ((Bundle)localObject1).putString("splitvia", str15);
        }
        ((Bundle)localObject1).putString("uin", paramString2);
        ((Bundle)localObject1).putString("vkey", paramString3);
        ((Bundle)localObject1).putString(DownloadConstants.a, str8);
        ((Bundle)localObject1).putString(DownloadConstants.b, str5);
        ((Bundle)localObject1).putString(DownloadConstants.c, str6);
        if (!TextUtils.isEmpty(str9)) {
          ((Bundle)localObject1).putString(DownloadConstants.e, str9);
        }
        ((Bundle)localObject1).putString(DownloadConstants.d, str13);
      }
      try
      {
        CommonDataAdapter.a().a(Integer.parseInt(paramString2));
        label802:
        CommonDataAdapter.a().a(paramString3);
        b(paramString4, str11, str8, str12);
        if ("2460".equals(paramString4))
        {
          a(paramString2, paramString3, str8, str10);
          if (i1 <= 0) {}
        }
        try
        {
          paramString1 = URLDecoder.decode(str7, "UTF-8");
          AppUtil.a(paramActivity, str8, str9, paramString1);
          return;
          break label237;
          label865:
          break label271;
          label868:
          break label305;
          label871:
          break label338;
          label874:
          break label371;
          if (TextUtils.isEmpty(str1))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          if (str1.equals("tmast"))
          {
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            i1 = AppUtil.a("com.tencent.android.qqdownloader");
            if ((!TextUtils.isEmpty(str16)) && (i1 > 0) && (i1 >= Integer.valueOf(str16).intValue()))
            {
              paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
              paramString1.setFlags(268435456);
              paramActivity.startActivity(paramString1);
              return;
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "online", (String)localObject2);
            return;
          }
          if (str1.equals("detail"))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          a(paramActivity, str8, paramString4, (Bundle)localObject1, str1, str2);
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1 = str7;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        break label802;
      }
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    LogUtility.b(a, "reportApkToYYB >>> " + paramBundle.toString());
    new HttpCgiAsyncTask("https://appic.qq.com/cgi-bin/appstage/get_apk_info", "GET", null).execute(new Bundle[] { paramBundle });
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("huin", paramString1);
    localBundle.putString("keytype", "256");
    localBundle.putString("keystr", paramString2);
    localBundle.putString("appid", paramString3);
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("requestkeys", paramString4);
    localBundle.putString("mode", "1");
    localBundle.putString("v", CommonDataAdapter.a().d());
    new HttpCgiAsyncTask("https://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi", "GET", null).execute(new Bundle[] { localBundle });
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    String str2 = paramBundle.getString("packageName");
    String str1 = paramBundle.getString("appId");
    StaticAnalyz.a("200", "ANDROIDQQ.SHARESOURCE", str1);
    if (MyAppApi.a().b())
    {
      Bundle localBundle = new Bundle();
      String str3 = DownloadConstants.a;
      paramBundle = str1;
      if (str1 == null) {
        paramBundle = "";
      }
      localBundle.putString(str3, paramBundle);
      localBundle.putString(DownloadConstants.b, "");
      localBundle.putString(DownloadConstants.c, "");
      localBundle.putString(DownloadConstants.e, str2);
      localBundle.putInt(DownloadConstants.d, 0);
      localBundle.putString(DownloadConstants.h, "ANDROIDQQ.SHARESOURCE");
      ThreadManager.b().post(new ldi(paramActivity, localBundle));
      return;
    }
    paramBundle = new Bundle();
    paramBundle.putString("uin", "");
    paramBundle.putString("sid", "");
    paramBundle.putString("via", "ANDROIDQQ.SHARESOURCE");
    paramBundle.putBoolean("autoDownload", false);
    paramBundle.putString("packageName", str2);
    paramBundle.putString("subpagetype", "SHARESOURCE");
    a(paramActivity, str1, 2462, paramBundle);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2460");
  }
  
  protected static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("2457".equals(paramString1)) {
      if (!TextUtils.isEmpty(paramString4)) {
        break label67;
      }
    }
    for (String str = "ANDROIDQQ.PCPUSH.AIOMSG";; str = paramString4)
    {
      StaticAnalyz.a("200", str, paramString3);
      if ("2460".equals(paramString1)) {}
      label67:
      try
      {
        paramString2 = StaticAnalyz.a(Integer.parseInt(paramString2));
        paramString1 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString1 = paramString2;
        }
        StaticAnalyz.a("200", paramString1, paramString3);
        return;
      }
      catch (NumberFormatException paramString1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient
 * JD-Core Version:    0.7.0.1
 */