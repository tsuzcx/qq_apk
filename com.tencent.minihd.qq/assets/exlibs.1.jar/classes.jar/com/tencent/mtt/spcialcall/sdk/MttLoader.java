package com.tencent.mtt.spcialcall.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kzy;

public class MttLoader
{
  public static final int a = 0;
  public static final String a = "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
  public static final int b = 1;
  public static final String b = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
  public static final int c = 2;
  public static final String c = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367";
  public static final int d = 3;
  public static final String d = "com.tencent.QQBrowser.action.VIEW";
  public static final int e = 4;
  public static final String e = "com.tencent.QQBrowser.action.VIEWSP";
  public static final int f = 5;
  public static final String f = "50079";
  private static final int g = 13;
  public static final String g = "50190";
  private static final int h = -1;
  @Deprecated
  public static final String h = "KEY_APPNAME";
  private static final int i = 0;
  @Deprecated
  public static final String i = "KEY_PKG";
  private static final int j = 1;
  @Deprecated
  public static final String j = "KEY_ACT";
  private static final int k = 2;
  public static final String k = "KEY_PID";
  private static final int l = 33;
  public static final String l = "KEY_EUSESTAT";
  private static final int jdField_m_of_type_Int = 42;
  private static final String jdField_m_of_type_JavaLangString = "loginType";
  private static final int jdField_n_of_type_Int = 420000;
  private static final String jdField_n_of_type_JavaLangString = "com.tencent.mtt";
  private static final String o = "com.tencent.mtt.x86";
  private static final String p = "com.tencent.qbx";
  private static final String q = "com.tencent.qbx5";
  
  public static int a(Activity paramActivity, String paramString, HashMap paramHashMap)
  {
    if (paramActivity == null) {
      return 3;
    }
    Object localObject2 = paramString;
    if (!a(paramString)) {
      localObject2 = "http://" + paramString;
    }
    Object localObject1;
    try
    {
      paramString = Uri.parse((String)localObject2);
      if (paramString == null) {
        return 2;
      }
      localObject1 = paramString;
      if (paramString.getScheme().toLowerCase().equals("qb"))
      {
        localObject1 = paramString;
        if (!a(paramActivity)) {
          localObject1 = Uri.parse("https://mdc.html5.qq.com/mh?channel_id=50079&u=" + URLEncoder.encode((String)localObject2, "UTF-8"));
        }
      }
      localObject2 = a(paramActivity);
      if (((MttLoader.BrowserInfo)localObject2).jdField_a_of_type_Int == -1) {
        return 4;
      }
    }
    catch (Exception paramActivity)
    {
      return 2;
    }
    if ((((MttLoader.BrowserInfo)localObject2).jdField_a_of_type_Int == 2) && (((MttLoader.BrowserInfo)localObject2).b < 33)) {
      return 5;
    }
    paramString = new Intent("android.intent.action.VIEW");
    if (((MttLoader.BrowserInfo)localObject2).jdField_a_of_type_Int == 2) {
      if ((((MttLoader.BrowserInfo)localObject2).b >= 33) && (((MttLoader.BrowserInfo)localObject2).b <= 39)) {
        paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      }
    }
    label584:
    for (;;)
    {
      paramString.setData((Uri)localObject1);
      if (paramHashMap != null)
      {
        localObject1 = paramHashMap.keySet();
        if (localObject1 != null)
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              String str = (String)paramHashMap.get(localObject2);
              if (!TextUtils.isEmpty(str))
              {
                paramString.putExtra((String)localObject2, str);
                continue;
                if ((((MttLoader.BrowserInfo)localObject2).b >= 40) && (((MttLoader.BrowserInfo)localObject2).b <= 45))
                {
                  paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                  break;
                }
                if (((MttLoader.BrowserInfo)localObject2).b < 46) {
                  break label584;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramActivity, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((kzy)localObject2).jdField_a_of_type_JavaLangString))) {
                  paramString.setClassName(((kzy)localObject2).b, ((kzy)localObject2).jdField_a_of_type_JavaLangString);
                }
                break;
                if (((MttLoader.BrowserInfo)localObject2).jdField_a_of_type_Int == 1)
                {
                  if (((MttLoader.BrowserInfo)localObject2).b == 1)
                  {
                    paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    break;
                  }
                  if (((MttLoader.BrowserInfo)localObject2).b != 2) {
                    break label584;
                  }
                  paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                  break;
                }
                if (((MttLoader.BrowserInfo)localObject2).jdField_a_of_type_Int == 0)
                {
                  if ((((MttLoader.BrowserInfo)localObject2).b >= 4) && (((MttLoader.BrowserInfo)localObject2).b <= 6))
                  {
                    paramString.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    break;
                  }
                  if (((MttLoader.BrowserInfo)localObject2).b <= 6) {
                    break label584;
                  }
                  paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                  localObject2 = a(paramActivity, (Uri)localObject1);
                  if ((localObject2 != null) && (!TextUtils.isEmpty(((kzy)localObject2).jdField_a_of_type_JavaLangString))) {
                    paramString.setClassName(((kzy)localObject2).b, ((kzy)localObject2).jdField_a_of_type_JavaLangString);
                  }
                  break;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramActivity, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((kzy)localObject2).jdField_a_of_type_JavaLangString))) {
                  paramString.setClassName(((kzy)localObject2).b, ((kzy)localObject2).jdField_a_of_type_JavaLangString);
                }
                break;
              }
            }
          }
        }
      }
      try
      {
        paramString.putExtra("loginType", 13);
        paramActivity.startActivity(paramString);
        return 0;
      }
      catch (ActivityNotFoundException paramActivity)
      {
        return 4;
      }
    }
  }
  
  public static MttLoader.BrowserInfo a(Context paramContext)
  {
    localBrowserInfo = new MttLoader.BrowserInfo();
    for (;;)
    {
      try
      {
        localPackageManager = paramContext.getPackageManager();
        localObject1 = null;
        try
        {
          localObject6 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
          localObject1 = localObject6;
          localBrowserInfo.jdField_a_of_type_Int = 2;
          localObject1 = localObject6;
          localBrowserInfo.jdField_a_of_type_JavaLangString = "ADRQB_";
          Object localObject3 = localObject6;
          if (localObject6 != null)
          {
            localObject1 = localObject6;
            localObject3 = localObject6;
            if (((PackageInfo)localObject6).versionCode > 420000)
            {
              localObject1 = localObject6;
              localBrowserInfo.b = ((PackageInfo)localObject6).versionCode;
              localObject1 = localObject6;
              localBrowserInfo.jdField_a_of_type_JavaLangString += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              return localBrowserInfo;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException3)
        {
          localObject4 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        PackageManager localPackageManager;
        Object localObject1;
        Object localObject6;
        Object localObject4;
        PackageInfo localPackageInfo1;
        Object localObject2;
        continue;
      }
      try
      {
        localObject1 = localPackageManager.getPackageInfo("com.tencent.qbx", 0);
        localObject4 = localObject1;
        localBrowserInfo.jdField_a_of_type_Int = 0;
        localObject4 = localObject1;
        localBrowserInfo.jdField_a_of_type_JavaLangString = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          localBrowserInfo.jdField_a_of_type_Int = 1;
          localObject4 = localPackageInfo1;
          localBrowserInfo.jdField_a_of_type_JavaLangString = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            localBrowserInfo.jdField_a_of_type_Int = 2;
            localObject2 = localObject4;
            localBrowserInfo.jdField_a_of_type_JavaLangString = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              localBrowserInfo.jdField_a_of_type_Int = 2;
              localObject2 = localPackageInfo2;
              localBrowserInfo.jdField_a_of_type_JavaLangString = "ADRQB_";
              paramContext = localPackageInfo2;
            }
            catch (Exception localException)
            {
              Object localObject5 = localObject2;
              try
              {
                localObject6 = a(paramContext, Uri.parse("https://mdc.html5.qq.com/mh?channel_id=50079&u="));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((kzy)localObject6).b)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((kzy)localObject6).b, 0);
                localObject5 = paramContext;
                localBrowserInfo.jdField_a_of_type_Int = 2;
                localObject5 = paramContext;
                localBrowserInfo.jdField_a_of_type_JavaLangString = "ADRQB_";
              }
              catch (Exception paramContext)
              {
                paramContext = (Context)localObject5;
              }
            }
          }
        }
      }
    }
    if (paramContext != null)
    {
      localBrowserInfo.b = paramContext.versionCode;
      localBrowserInfo.jdField_a_of_type_JavaLangString += paramContext.versionName.replaceAll("\\.", "");
    }
    return localBrowserInfo;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      if (paramString.toLowerCase().startsWith("qb://"))
      {
        paramContext = a(paramContext);
        if (paramContext.jdField_a_of_type_Int == -1) {}
        while (i1 != 0)
        {
          return a(paramString);
          if ((paramContext.jdField_a_of_type_Int != 2) || (paramContext.b >= 33)) {
            i1 = 0;
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = "https://mdc.html5.qq.com/mh?channel_id=50079&u=" + URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
  }
  
  private static kzy a(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
      return null;
    }
    paramContext = new kzy(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.jdField_a_of_type_JavaLangString = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.jdField_a_of_type_JavaLangString = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext.jdField_a_of_type_Int == -1) {}
    while ((paramContext.jdField_a_of_type_Int == 2) && (paramContext.b < 42)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int i1;
    int i2;
    do
    {
      return false;
      paramString = paramString.trim();
      i1 = paramString.toLowerCase().indexOf("://");
      i2 = paramString.toLowerCase().indexOf('.');
    } while ((i1 > 0) && (i2 > 0) && (i1 > i2));
    return paramString.toLowerCase().contains("://");
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext).jdField_a_of_type_Int != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mtt.spcialcall.sdk.MttLoader
 * JD-Core Version:    0.7.0.1
 */