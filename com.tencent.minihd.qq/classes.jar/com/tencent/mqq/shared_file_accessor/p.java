package com.tencent.mqq.shared_file_accessor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class p
{
  static boolean a = false;
  private static final Uri b = Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl.2/save");
  private static String c = "";
  
  static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)Class.forName("com.tencent.common.app.BaseApplicationImpl").getMethod("getSystemSharedPreferences", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { paramString, Integer.valueOf(paramInt) });
      paramContext = localSharedPreferences;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      do
      {
        if (0 != 0) {
          break label98;
        }
        paramString = paramContext.getSharedPreferences(paramString, paramInt);
        if ((paramString instanceof n)) {
          break;
        }
        paramContext = paramString;
      } while (!(paramString instanceof l));
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label53;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label53;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label53;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label53:
      break label53;
    }
    return paramContext;
    label98:
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((c != null) && (c.length() != 0)) {}
    while (paramContext == null) {
      return;
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    if (!paramContext.hasNext()) {}
    for (;;)
    {
      a = "com.tencent.minihd.qq".equals(c);
      return;
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid != i) {
        break;
      }
      c = localRunningAppProcessInfo.processName;
    }
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.getContentResolver().update(b, new ContentValues(0), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.p
 * JD-Core Version:    0.7.0.1
 */