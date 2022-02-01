package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class q
{
  private static File a = null;
  private static String b = "";
  private static String c = "";
  private static int d = -1;
  private static String e = "";
  private static String f = null;
  private static int g = 0;
  private static String h = null;
  private static boolean i = false;
  private static boolean j = false;
  private static String k = "unknown";
  private static int l = -1;
  private static int m = -1;
  private static int n = -1;
  private static int o = -1;
  private static int p = -1;
  
  private static int a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new File(FileUtil.a(paramContext, paramString, paramInt1, true), TbsDownloader.getBackupFileName(false, paramInt2));
    paramInt2 = -1;
    paramInt1 = paramInt2;
    if (paramString.exists())
    {
      paramInt1 = paramInt2;
      if (paramString.canRead())
      {
        paramInt2 = a.b(paramString);
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = a.a(paramContext, paramString);
        }
      }
    }
    return paramInt1;
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l1;
  }
  
  public static void a(int paramInt)
  {
    d = paramInt;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    int i1 = 64;
    for (;;)
    {
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          return;
        }
        if (!l(paramContext)) {
          break;
        }
        String str = "thirdapp_" + paramString1;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString1 = "";
          paramString1 = new StringBuilder().append(paramString1).append("mycpuis");
          if (!b.b()) {
            break label243;
          }
          paramString1 = i1;
          paramString1 = paramString1 + "_" + "64scoreis" + TbsShareManager.getTbsStableCoreVersion(paramContext, 64);
          paramString1 = paramString1 + "_" + "32scoreis" + TbsShareManager.getTbsStableCoreVersion(paramContext, 32);
          com.tencent.smtt.sdk.stat.b.a(paramContext, str, paramString1);
          TbsLog.i("uploadThirdAppCoreUpdate", "action is " + str + " p1 is " + paramString1);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.i("uploadThirdAppCoreUpdate", "stack is  " + Log.getStackTraceString(paramContext));
        return;
      }
      paramString1 = paramString2 + "_";
      continue;
      label243:
      i1 = 32;
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (TextUtils.isEmpty(b))
    {
      b = paramString;
      return;
    }
    b = b + "&" + paramString;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      if (a == null) {
        try
        {
          if (paramContext.getApplicationInfo().processName.contains("com.tencent.mm"))
          {
            paramContext = QbSdk.getTbsFolderDir(paramContext);
            if ((paramContext != null) && (paramContext.isDirectory()))
            {
              paramContext = new File(paramContext, "share");
              if (paramContext != null)
              {
                if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
                  continue;
                }
                a = paramContext;
                paramContext.setExecutable(true, false);
                return true;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }
  
  public static String b()
  {
    if (QbSdk.getIsSysWebViewForcedByOuter()) {
      return "SysWebViewForcedByOuter";
    }
    if (QbSdk.getIsInitX5Environment()) {}
    for (String str = "pre";; str = "nopre") {
      return str + "&" + b;
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    int i1 = 64;
    for (;;)
    {
      try
      {
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          return;
        }
        if (!k(paramContext)) {
          break;
        }
        if (TextUtils.isEmpty(paramString2))
        {
          paramString2 = "";
          paramString2 = new StringBuilder().append(paramString2).append("mycpuis");
          if (!b.b()) {
            break label222;
          }
          paramString2 = i1;
          paramString2 = paramString2 + "_" + "64scoreis" + TbsShareManager.getTbsStableCoreVersion(paramContext, 64);
          paramString2 = paramString2 + "_" + "32scoreis" + TbsShareManager.getTbsStableCoreVersion(paramContext, 32);
          com.tencent.smtt.sdk.stat.b.a(paramContext, paramString1, paramString2);
          TbsLog.i("recordStableUpdate", "action is " + paramString1 + " p1 is " + paramString2);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.i("recordStableUpdate", "stack is  " + Log.getStackTraceString(paramContext));
        return;
      }
      paramString2 = paramString2 + "_";
      continue;
      label222:
      i1 = 32;
    }
  }
  
  public static void b(String paramString)
  {
    e = paramString;
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        TbsLog.i("TbsUtils", "isStableCoreForHostEnable app is thirdapp return is false ");
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(localThrowable));
    }
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("scfh", true);
      try
      {
        Log.d("TbsUtils", "isStableCoreForHostEnable is " + bool);
        TbsLog.i("TbsUtils", "isStableCoreForHostEnable is " + bool);
        c localc = c.a();
        localc.a(paramContext, Integer.valueOf(1003), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("scfh", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1003](" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1009), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("scfh", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1009](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext) {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool = true;
      }
    }
    TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    return bool;
  }
  
  public static void c()
  {
    b = "";
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("ucup", true);
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("TbsUtils", "isUploadCoreUpdateEnable is " + bool);
        TbsLog.i("TbsUtils", "isUploadCoreUpdateEnable is " + bool);
        c.a().a(paramContext, Integer.valueOf(1005), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("ucup", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1005](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label97;
      }
      paramContext = paramContext;
      bool = true;
    }
    label97:
    return bool;
  }
  
  public static String d()
  {
    return e;
  }
  
  public static String d(Context paramContext)
  {
    if (!TextUtils.isEmpty(c))
    {
      Log.d("TbsUtils", "getBuildModel cache is " + c);
      return c;
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("sai", 0);
      c = paramContext.getString("bmo", "");
      if (!TextUtils.isEmpty(c))
      {
        Log.d("TbsUtils", "getBuildModel sp is " + c);
        return c;
      }
      c = Build.MODEL;
      Log.d("TbsUtils", "getBuildModel is " + c);
      TbsLog.i("TbsUtils", "getBuildModel is " + c);
      paramContext = paramContext.edit();
      paramContext.putString("bmo", c);
      paramContext.commit();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    return c;
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("rrff", false);
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("TbsUtils", "isReadResponseFromFileEnable is " + bool);
        TbsLog.i("TbsUtils", "isReadResponseFromFileEnable is " + bool);
        c.a().a(paramContext, Integer.valueOf(1006), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("rrff", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1006](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label97;
      }
      paramContext = paramContext;
      bool = false;
    }
    label97:
    return bool;
  }
  
  public static boolean f(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("fwdn", false);
      c localc;
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        TbsLog.i("TbsUtils", "isReadResponseFromFileEnable is " + bool);
        localc = c.a();
        localc.a(paramContext, Integer.valueOf(1007), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("fwdn", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command 1007(" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1008), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("fwdn", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command 1008(" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label91;
      }
      paramContext = paramContext;
      bool = false;
    }
    label91:
    return bool;
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("cbau", false);
      c localc;
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("TbsUtils", "isClearBackupEnable is " + bool);
        TbsLog.i("TbsUtils", "isClearBackupEnable is " + bool);
        localc = c.a();
        localc.a(paramContext, Integer.valueOf(1013), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("cbau", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1013](" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1014), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("cbau", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1014](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label118;
      }
      paramContext = paramContext;
      bool = false;
    }
    label118:
    return bool;
  }
  
  public static boolean h(Context paramContext)
  {
    if (QbSdk.getTbsVersion(paramContext) == d)
    {
      TbsLog.i("TbsUtils", "isUploadCoreSourceEnable core source version " + d + " already uploaded and return ");
      return false;
    }
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("ucst", true);
      try
      {
        Log.d("TbsUtils", "isUploadCoreSourceEnable is " + bool);
        TbsLog.i("TbsUtils", "isUploadCoreSourceEnable is " + bool);
        c localc = c.a();
        localc.a(paramContext, Integer.valueOf(1016), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("ucst", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1016](" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1015), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("ucst", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1015](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext) {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool = true;
      }
    }
    TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    return bool;
  }
  
  public static boolean i(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.getApplicationInfo().packageName.contains("com.tencent.qqmusic");
      if (bool2) {
        bool1 = true;
      }
    }
    catch (Throwable paramContext)
    {
      label22:
      break label22;
    }
    TbsLog.i("TbsUtils", "shouldUploadDestroyCode is " + bool1);
    return bool1;
  }
  
  public static String j(Context paramContext)
  {
    l = a(paramContext, "com.tencent.mm", 3, 32);
    m = a(paramContext, "com.tencent.mm", 3, 64);
    n = a(paramContext, "com.tencent.mobileqq", 3, 32);
    o = a(paramContext, "com.tencent.mm", 4, 32);
    p = a(paramContext, "com.tencent.mm", 4, 64);
    m(paramContext);
    String str = "coretype" + "=ctis=" + k;
    int i1 = TbsShareManager.getSharedTbsCoreVersion(paramContext, "com.tencent.mm");
    int i2 = TbsShareManager.getSharedTbsCoreVersion(paramContext, "com.tencent.mobileqq");
    int i3 = TbsShareManager.getCoreShareDecoupleCoreVersion(paramContext, "com.tencent.mm");
    int i4 = TbsShareManager.getCoreShareDecoupleCoreVersion(paramContext, "com.tencent.mobileqq");
    paramContext = "wx" + "=ceis=" + i1 + "_" + "wxd" + "=ceis=" + i3 + "_" + "qq" + "=ceis=" + i2 + "_" + "qqd" + "=ceis=" + i4 + "_" + "wxb32" + "=ceis=" + l + "_" + "wxb64" + "=ceis=" + m + "_" + "qqb" + "=ceis=" + n + "_" + "s32" + "=ceis=" + o + "_" + "s64" + "=ceis=" + p;
    return str + "=split=" + paramContext;
  }
  
  public static boolean k(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("rscu", false);
      c localc;
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("TbsUtils", "isRecordStableUpdateEnable is " + bool);
        TbsLog.i("TbsUtils", "isRecordStableUpdateEnable is " + bool);
        localc = c.a();
        localc.a(paramContext, Integer.valueOf(1017), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("rscu", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1017](" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1018), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("rscu", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1018](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label118;
      }
      paramContext = paramContext;
      bool = false;
    }
    label118:
    return bool;
  }
  
  public static boolean l(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("utcu", false);
      c localc;
      TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("TbsUtils", "isUploadThirdAppCoreUpdateEnable is " + bool);
        TbsLog.i("TbsUtils", "isUploadThirdAppCoreUpdateEnable is " + bool);
        localc = c.a();
        localc.a(paramContext, Integer.valueOf(1019), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("utcu", true);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1019](" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1020), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("utcu", false);
            localEditor.commit();
            TbsLog.e("TbsUtils", "Execute command [1020](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label118;
      }
      paramContext = paramContext;
      bool = false;
    }
    label118:
    return bool;
  }
  
  private static void m(Context paramContext)
  {
    try
    {
      Object localObject1 = TbsShareManager.getTbsShareFile(paramContext, "core_info");
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = new BufferedInputStream(new FileInputStream((File)localObject1));
      localObject1 = new Properties();
      ((Properties)localObject1).load((InputStream)localObject2);
      localObject2 = ((Properties)localObject1).getProperty("core_version", "");
      if (!"".equals(localObject2)) {
        g = Math.max(Integer.parseInt((String)localObject2), 0);
      }
      localObject2 = ((Properties)localObject1).getProperty("core_packagename", "");
      if (!"".equals(localObject2)) {
        h = (String)localObject2;
      }
      localObject2 = ((Properties)localObject1).getProperty("core_path", "");
      if (!"".equals(localObject2))
      {
        f = (String)localObject2;
        if (!f.contains("com.tencent.mm")) {
          break label198;
        }
        k = "shareFromWX";
        if (f.contains(paramContext.getApplicationInfo().packageName))
        {
          k = "downloadOWN";
          if ((g != o) && (g != p)) {
            break label219;
          }
          k = "copyFromStable";
        }
      }
      for (;;)
      {
        i = Boolean.parseBoolean(((Properties)localObject1).getProperty("core_disabled", "false"));
        return;
        label198:
        if (!f.contains("com.tencent.mobileqq")) {
          break;
        }
        k = "shareFromQQ";
        break;
        label219:
        if ((g == l) || (g == m)) {
          k = "copyBackupFromWX";
        } else if (g == n) {
          k = "copyBackupFromQQ";
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.q
 * JD-Core Version:    0.7.0.1
 */