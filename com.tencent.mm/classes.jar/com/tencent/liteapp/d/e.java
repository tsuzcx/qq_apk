package com.tencent.liteapp.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e
{
  private static boolean aA(Context paramContext)
  {
    AppMethodBeat.i(258866);
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      AppMethodBeat.o(258866);
      return true;
    }
    AppMethodBeat.o(258866);
    return false;
  }
  
  public static int aB(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(258867);
    if (av(paramContext))
    {
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = az(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(258867);
      return j;
    }
    AppMethodBeat.o(258867);
    return 0;
  }
  
  public static int at(Context paramContext)
  {
    AppMethodBeat.i(258842);
    int i = z(paramContext, d.as(paramContext));
    AppMethodBeat.o(258842);
    return i;
  }
  
  private static Point au(Context paramContext)
  {
    AppMethodBeat.i(258847);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(258847);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {}
      try
      {
        Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
        localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      }
      catch (NoSuchMethodException paramContext)
      {
        continue;
        paramContext.getSize(localPoint);
      }
      catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
    }
  }
  
  @TargetApi(17)
  public static boolean av(Context paramContext)
  {
    AppMethodBeat.i(258850);
    if ((az(paramContext) > 0) && ((paramContext == null) || (aw(paramContext))))
    {
      AppMethodBeat.o(258850);
      return true;
    }
    AppMethodBeat.o(258850);
    return false;
  }
  
  private static boolean aw(Context paramContext)
  {
    AppMethodBeat.i(258853);
    if ((ay(paramContext)) && (!ax(paramContext)))
    {
      AppMethodBeat.o(258853);
      return true;
    }
    AppMethodBeat.o(258853);
    return false;
  }
  
  private static boolean ax(Context paramContext)
  {
    AppMethodBeat.i(258859);
    String str1;
    try
    {
      String str2 = Build.BRAND;
      str1 = str2;
      if (!isNullOrNil(str2)) {
        str1 = str2.toLowerCase();
      }
      if ((!isNullOrNil(str1)) && ((str1.contains("vivo")) || (str1.contains("oppo"))))
      {
        if (Settings.Secure.getInt(paramContext.getContentResolver(), cZ(str1), 0) != 0)
        {
          AppMethodBeat.o(258859);
          return true;
        }
        AppMethodBeat.o(258859);
        return false;
      }
      if ((isNullOrNil(str1)) || (!str1.contains("nokia"))) {
        break label142;
      }
      if ((Settings.Secure.getInt(paramContext.getContentResolver(), "swipe_up_to_switch_apps_enabled", 0) == 1) || (Settings.System.getInt(paramContext.getContentResolver(), "navigation_bar_can_hiden", 0) != 0))
      {
        AppMethodBeat.o(258859);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(258859);
      return false;
    }
    AppMethodBeat.o(258859);
    return false;
    label142:
    if (Settings.Global.getInt(paramContext.getContentResolver(), cZ(str1), 0) != 0)
    {
      AppMethodBeat.o(258859);
      return true;
    }
    AppMethodBeat.o(258859);
    return false;
  }
  
  private static boolean ay(Context paramContext)
  {
    AppMethodBeat.i(258863);
    boolean bool;
    if (Build.VERSION.SDK_INT > 28) {
      try
      {
        Object localObject = Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);
        bool = ((Boolean)localObject.getClass().getMethod("hasNavigationBar", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { paramContext.getClass().getMethod("getDisplayId", new Class[0]).invoke(paramContext, new Object[0]) })).booleanValue();
        AppMethodBeat.o(258863);
        return bool;
      }
      catch (Exception paramContext)
      {
        b.e("WeUIToolHelper", "deviceHasNavigationBar Exception:%s", new Object[] { paramContext });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(258863);
      return true;
      try
      {
        paramContext = Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);
        bool = ((Boolean)paramContext.getClass().getMethod("hasNavigationBar", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
        AppMethodBeat.o(258863);
        return bool;
      }
      catch (Exception paramContext)
      {
        b.e("WeUIToolHelper", "deviceHasNavigationBar Exception:%s", new Object[] { paramContext });
      }
    }
  }
  
  private static int az(Context paramContext)
  {
    AppMethodBeat.i(258864);
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = au(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    if (aA(paramContext)) {
      i = ((Point)localObject1).y;
    }
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom, ((Rect)localObject1).right);
      if (aA(paramContext)) {
        i = ((Rect)localObject1).bottom;
      }
    }
    AppMethodBeat.o(258864);
    return j - i;
  }
  
  private static String cZ(String paramString)
  {
    AppMethodBeat.i(258861);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(258861);
      return "navigationbar_is_min";
    }
    if ((paramString.contains("huawei")) || (paramString.contains("honor")))
    {
      AppMethodBeat.o(258861);
      return "navigationbar_is_min";
    }
    if ((paramString.contains("xiaomi")) || (paramString.contains("redmi")))
    {
      AppMethodBeat.o(258861);
      return "force_fsg_nav_bar";
    }
    if (paramString.contains("vivo"))
    {
      AppMethodBeat.o(258861);
      return "navigation_gesture_on";
    }
    if (paramString.contains("oppo"))
    {
      AppMethodBeat.o(258861);
      return "hide_navigationbar_enable";
    }
    if (paramString.contains("samsung"))
    {
      AppMethodBeat.o(258861);
      return "navigationbar_hide_bar_enabled";
    }
    if (paramString.contains("nokia"))
    {
      if (Build.VERSION.SDK_INT < 28)
      {
        AppMethodBeat.o(258861);
        return "navigation_bar_can_hiden";
      }
      AppMethodBeat.o(258861);
      return "swipe_up_to_switch_apps_enabled";
    }
    AppMethodBeat.o(258861);
    return "navigationbar_is_min";
  }
  
  private static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(258856);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(258856);
      return true;
    }
    AppMethodBeat.o(258856);
    return false;
  }
  
  private static int z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(258845);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = f.df(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      label49:
      break label49;
    }
    b.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(258845);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.d.e
 * JD-Core Version:    0.7.0.1
 */