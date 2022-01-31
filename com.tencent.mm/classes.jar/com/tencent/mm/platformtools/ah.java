package com.tencent.mm.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Debug;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.plugin.w.c;
import com.tencent.mm.plugin.w.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class ah
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  private static final long[] eTU = { 300L, 200L, 300L, 200L };
  
  public static boolean I(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!i(paramContext, localIntent))
    {
      y.e("MicroMsg.Util", "jump to url failed, " + paramString);
      return false;
    }
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static long UX()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long UY()
  {
    return System.currentTimeMillis();
  }
  
  public static long UZ()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public static void Va()
  {
    y.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", new Object[] { cm(Debug.getGlobalAllocSize()), cm(Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize()), cm(Debug.getGlobalExternalAllocSize()), cm(Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize()), cm(Debug.getNativeHeapAllocatedSize()), cm(Debug.getNativeHeapSize()) });
  }
  
  public static a Vb()
  {
    return new a();
  }
  
  public static boolean a(Context paramContext, View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return false;
        paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      } while (paramContext == null);
      paramView = paramView.getWindowToken();
    } while (paramView == null);
    try
    {
      bool = paramContext.hideSoftInputFromWindow(paramView, 0);
      return bool;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        y.e("MicroMsg.Util", "hide VKB(View) exception %s", new Object[] { paramContext });
        boolean bool = false;
      }
    }
  }
  
  public static int aD(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return 0;
      if ((paramObject instanceof Integer)) {
        return ((Integer)paramObject).intValue();
      }
    } while (!(paramObject instanceof Long));
    return ((Long)paramObject).intValue();
  }
  
  public static String aM(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static List<String> aN(String paramString1, String paramString2)
  {
    String str = null;
    if (paramString1 != null)
    {
      paramString2 = Pattern.compile(paramString2).matcher(paramString1);
      int j = paramString2.groupCount();
      int i = 1;
      paramString1 = new ArrayList();
      str = paramString1;
      if (paramString2.find()) {
        for (;;)
        {
          str = paramString1;
          if (i > j) {
            break;
          }
          paramString1.add(paramString2.group(i));
          i += 1;
        }
      }
    }
    return str;
  }
  
  private static String bC(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      y.i("MicroMsg.Util", "top activity name =" + paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
    }
    return "(null)";
  }
  
  public static boolean bC(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
  
  public static boolean bD(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
  }
  
  public static boolean bU(Context paramContext)
  {
    String str = paramContext.getClass().getName();
    paramContext = bC(paramContext);
    y.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    return paramContext.equalsIgnoreCase(str);
  }
  
  public static boolean bV(Context paramContext)
  {
    if (d.bkt() != null) {
      d.bkt().bkr();
    }
    Intent localIntent;
    if ((e.bvl & 0x1) != 0)
    {
      y.e("MicroMsg.Util", "package has set external update mode");
      Uri localUri = Uri.parse(e.uej);
      localIntent = new Intent("android.intent.action.VIEW", localUri).addFlags(268435456);
      if ((localUri == null) || (localIntent == null) || (!i(paramContext, localIntent)))
      {
        y.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
      }
    }
    do
    {
      return true;
      y.i("MicroMsg.Util", "parse market uri ok");
      paramContext.startActivity(localIntent);
      return true;
      ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000L).commit();
    } while (d.bkt() == null);
    paramContext = d.bkt().a(paramContext, new ah.1());
    if (paramContext == null) {
      return false;
    }
    paramContext.update(3);
    return true;
  }
  
  public static boolean bl(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static long c(Long paramLong)
  {
    if (paramLong == null) {
      return 0L;
    }
    return paramLong.longValue();
  }
  
  public static String c(List<String> paramList, String paramString)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    if (i < paramList.size())
    {
      if (i == paramList.size() - 1) {
        localStringBuilder.append(((String)paramList.get(i)).trim());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(((String)paramList.get(i)).trim() + paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean c(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return true;
    }
    return paramBoolean.booleanValue();
  }
  
  public static String cm(long paramLong)
  {
    float f;
    if (paramLong >> 20 > 0L)
    {
      f = Math.round((float)paramLong * 10.0F / 1048576.0F) / 10.0F;
      return f + "MB";
    }
    if (paramLong >> 9 > 0L)
    {
      f = Math.round((float)paramLong * 10.0F / 1024.0F) / 10.0F;
      return f + "KB";
    }
    return paramLong + "B";
  }
  
  public static long cn(long paramLong)
  {
    return System.currentTimeMillis() / 1000L - paramLong;
  }
  
  public static long co(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public static long cp(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }
  
  public static long d(Long paramLong)
  {
    if (paramLong == null) {
      return 0L;
    }
    return paramLong.longValue();
  }
  
  public static boolean d(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue();
  }
  
  public static boolean e(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return true;
    }
    return paramBoolean.booleanValue();
  }
  
  public static int g(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  @Deprecated
  public static int getInt(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        y.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
    return paramInt;
  }
  
  public static int h(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  public static List<String> h(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean i(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  public static String jL(int paramInt)
  {
    return String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
  }
  
  public static boolean jM(int paramInt)
  {
    long l1 = paramInt * 1000L;
    long l2 = l1 - System.currentTimeMillis();
    y.d("MicroMsg.Util", "time " + l1 + "  systime " + System.currentTimeMillis() + " diff " + l2);
    return l2 < 0L;
  }
  
  public static String pl(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    return str;
  }
  
  public static String pm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  @Deprecated
  public static long pn(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      y.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return -1L;
  }
  
  public static final class a
  {
    public final String toString()
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length < 4)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 3;
      while (i < arrayOfStackTraceElement.length)
      {
        if (arrayOfStackTraceElement[i].getClassName().contains("com.tencent.mm"))
        {
          localStringBuilder.append("[");
          localStringBuilder.append(arrayOfStackTraceElement[i].getClassName().substring(15));
          localStringBuilder.append(":");
          localStringBuilder.append(arrayOfStackTraceElement[i].getMethodName());
          localStringBuilder.append("(" + arrayOfStackTraceElement[i].getLineNumber() + ")]");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.ah
 * JD-Core Version:    0.7.0.1
 */