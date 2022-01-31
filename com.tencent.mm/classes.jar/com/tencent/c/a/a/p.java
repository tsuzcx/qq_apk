package com.tencent.c.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class p
{
  private static volatile p btK = null;
  private boolean btL = false;
  private Context context = null;
  
  private p(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.btL = s.l(this.context, "android.permission.WRITE_SETTINGS");
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      paramContext = Settings.System.class.getDeclaredMethod("canWrite", new Class[] { Context.class });
      paramContext.setAccessible(true);
      this.btL = ((Boolean)paramContext.invoke(null, new Object[] { this.context })).booleanValue();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static p ao(Context paramContext)
  {
    if (btK == null) {}
    try
    {
      if (btK == null) {
        btK = new p(paramContext);
      }
      return btK;
    }
    finally {}
  }
  
  public final boolean o(String paramString1, String paramString2)
  {
    if (this.btL) {
      try
      {
        boolean bool = Settings.System.putString(this.context.getContentResolver(), paramString1, paramString2);
        return bool;
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.c.a.a.p
 * JD-Core Version:    0.7.0.1
 */