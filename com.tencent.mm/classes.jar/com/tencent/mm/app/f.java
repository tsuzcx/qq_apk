package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class f
{
  public static int aC(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static int aD(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 3072);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = paramContext.getSharedPreferences("crash_status_file", 4);
      paramContext = ((SharedPreferences)localObject).getString("crashlist", "");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("crashlist", paramContext + ";" + paramString1 + "," + paramString2);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static abstract interface a
  {
    public abstract void er(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.f
 * JD-Core Version:    0.7.0.1
 */