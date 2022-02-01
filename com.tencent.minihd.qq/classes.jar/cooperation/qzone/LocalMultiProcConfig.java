package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import common.qzone.component.util.SecurityUtil;

public class LocalMultiProcConfig
{
  public static final String a = "Qz_setting";
  public static final String b = "QZ_QQ_shared_setting";
  public static final String c = "QZ_video_shared_setting";
  public static final String d = "QZ_Per_Config";
  public static final String e = "Widget_";
  private static final String f = "preference";
  
  public static int a(String paramString, int paramInt)
  {
    return a("QZ_QQ_shared_setting", paramString, paramInt);
  }
  
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      int i = a(Long.valueOf(paramString2).longValue()).getInt(paramString1, paramInt);
      return i;
    }
    catch (NumberFormatException paramString1) {}
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1).getInt(paramString2, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return a("QZ_QQ_shared_setting").getLong(paramString, paramLong);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1).getLong(paramString2, paramLong);
  }
  
  private static SharedPreferences a(long paramLong)
  {
    if (paramLong == 0L) {
      return a("QZ_QQ_shared_setting");
    }
    return a(SecurityUtil.a(String.valueOf(paramLong)) + "_" + "preference");
  }
  
  @SuppressLint({"InlinedApi"})
  private static SharedPreferences a(String paramString)
  {
    Context localContext = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localContext.getSharedPreferences(paramString, i);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramLong).getString(paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1).getString(paramString2, paramString3);
  }
  
  @SuppressLint({"NewApi"})
  private static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT < 9)
    {
      paramEditor.commit();
      return;
    }
    paramEditor.apply();
  }
  
  public static void a(String paramString, int paramInt)
  {
    a("QZ_QQ_shared_setting", paramString, paramInt);
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    a(localEditor);
  }
  
  public static void a(String paramString, long paramLong)
  {
    b("QZ_QQ_shared_setting", paramString, paramLong);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putInt(paramString2, paramInt);
    a(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putString(paramString1, paramString2);
    a(localEditor);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putString(paramString2, paramString3);
    a(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putBoolean(paramString2, paramBoolean);
    a(paramString1);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1).getBoolean(paramString2, paramBoolean);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static void b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putLong(paramString2, paramLong);
    a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qzone.LocalMultiProcConfig
 * JD-Core Version:    0.7.0.1
 */