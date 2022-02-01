package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.OpenConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlPolicyUtil
{
  protected static final String A = "Common_tips_dialog_interval";
  protected static final String B = "Common_require_root_interval";
  protected static final String C = "Common_yyb_wifi_download_Switch";
  protected static final int a = 3;
  protected static final String a = "Common_MyAppDownload_Flag";
  protected static final String b = "Common_Show_Dialog_Flag";
  protected static final String c = "Common_Dialog_Only_Once_Flag";
  protected static final String d = "Common_Max_Count";
  protected static final String e = "Common_Detail_Page";
  protected static final String f = "Common_Release_Control";
  protected static final String g = "Common_InstallYYB_Install_Words";
  protected static final String h = "Common_InstallYYB_Update_Words";
  protected static final String i = "Common_UpdateYYB_Install_Words";
  protected static final String j = "Common_UpdateYYB_Update_Words";
  protected static final String k = "Common_GC_InstallYYB_Install_Words";
  protected static final String l = "Common_GC_InstallYYB_Update_Words";
  protected static final String m = "Common_GC_UpdateYYB_Install_Words";
  protected static final String n = "Common_GC_UpdateYYB_Update_Words";
  protected static final String o = "Common_QQUpdate_InstallYYB_Update_Words";
  protected static final String p = "Common_QQUpdate_UpdateYYB_Update_Words";
  protected static final String q = "share_myAppApi";
  protected static final String r = "SP_Show_Dialog_Count";
  protected static final String s = "SP_Show_Dialog_Date";
  protected static final String t = "SP_Has_shown_Dialog";
  public static final String u = "package_scan";
  protected static final String v = "SP_Lastest_require_time";
  protected static final String w = "Common_QQ_VERSION";
  protected static final String x = "Common_QQ_CARRY_IDENTITY";
  protected static final String y = "Common_root_autoinstall_flag";
  protected static final String z = "Common_myapp_download_url";
  
  public static long a()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_tips_dialog_interval");
  }
  
  public static String a()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_myapp_download_url");
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt2 == 2) {
      switch (paramInt1)
      {
      default: 
        str = "Common_GC_InstallYYB_Install_Words";
      }
    }
    for (;;)
    {
      return OpenConfig.a(CommonDataAdapter.a().a(), null).b(str);
      str = "Common_GC_InstallYYB_Install_Words";
      continue;
      str = "Common_GC_InstallYYB_Update_Words";
      continue;
      str = "Common_GC_UpdateYYB_Install_Words";
      continue;
      str = "Common_GC_UpdateYYB_Update_Words";
      continue;
      if (paramInt2 == 1) {
        switch (paramInt1)
        {
        case 2: 
        default: 
          str = null;
          break;
        case 1: 
          str = "Common_QQUpdate_InstallYYB_Update_Words";
          break;
        case 3: 
          str = "Common_QQUpdate_UpdateYYB_Update_Words";
          break;
        }
      } else {
        switch (paramInt1)
        {
        default: 
          str = "Common_InstallYYB_Install_Words";
          break;
        case 1: 
          str = "Common_InstallYYB_Install_Words";
          break;
        case 2: 
          str = "Common_InstallYYB_Update_Words";
          break;
        case 3: 
          str = "Common_UpdateYYB_Install_Words";
          break;
        case 4: 
          str = "Common_UpdateYYB_Update_Words";
        }
      }
    }
  }
  
  public static void a()
  {
    int i1 = 1;
    if (!OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Show_Dialog_Flag")) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localObject = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
      localEditor = ((SharedPreferences)localObject).edit();
      if (OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Dialog_Only_Once_Flag"))
      {
        localEditor.putBoolean("SP_Has_shown_Dialog", true);
        localEditor.commit();
        return;
      }
      i2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Max_Count");
    } while ((i2 == -1) || (i2 == 0));
    int i2 = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
    Object localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
    String str = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    if (str.equals(localObject)) {
      i1 = i2 + 1;
    }
    localEditor.putInt("SP_Show_Dialog_Count", i1);
    localEditor.putString("SP_Show_Dialog_Date", str);
    localEditor.commit();
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0).edit();
    localEditor.putLong("SP_Lastest_require_time", paramLong);
    localEditor.commit();
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l1 = localSharedPreferences.getLong("SP_Lastest_require_time", paramLong);
    if (paramLong - l1 >= b())
    {
      localEditor.putLong("SP_Lastest_require_time", paramLong);
      localEditor.commit();
    }
    while (paramLong == l1) {
      return true;
    }
    return false;
  }
  
  public static long b()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_require_root_interval");
  }
  
  public static boolean b()
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    Object localObject = "";
    if (localDownloadInfo != null) {
      localObject = localDownloadInfo.k;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean c()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_root_autoinstall_flag") <= 0;
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AppUtil.a("com.tencent.android.qqdownloader") > 4001126)
    {
      bool1 = bool2;
      if (OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_CARRY_IDENTITY")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean e()
  {
    Object localObject = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Release_Control").trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        return true;
      } while (((String)localObject).equals("-1"));
      if (((String)localObject).equals("-2")) {
        return false;
      }
      localObject = ((String)localObject).split(";");
    } while (localObject == null);
    String str1 = String.valueOf(CommonDataAdapter.a().a());
    if (str1 == null) {
      return false;
    }
    int i2 = localObject.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label115;
      }
      String str2 = localObject[i1];
      if ((str2.length() == 2) && (str1.endsWith(str2))) {
        break;
      }
      i1 += 1;
    }
    label115:
    return false;
  }
  
  public static boolean f()
  {
    if (!OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Show_Dialog_Flag")) {}
    int i1;
    int i2;
    do
    {
      boolean bool;
      do
      {
        return false;
        localObject = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
        bool = ((SharedPreferences)localObject).getBoolean("SP_Has_shown_Dialog", false);
        if (!OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Dialog_Only_Once_Flag")) {
          break;
        }
      } while (bool);
      return true;
      i1 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Max_Count");
      LogUtility.c("OpenConfig-MyAppApi", " maxCount = " + i1);
      if ((i1 == -1) || (i1 == 0)) {
        return true;
      }
      i2 = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
      Object localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
      if (!new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())).equals(localObject)) {
        break;
      }
    } while (i2 >= i1);
    return true;
    return true;
  }
  
  public static boolean g()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_MyAppDownload_Flag");
  }
  
  public static boolean h()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Detail_Page");
  }
  
  public static boolean i()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_yyb_wifi_download_Switch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.ControlPolicyUtil
 * JD-Core Version:    0.7.0.1
 */