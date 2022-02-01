package com.tencent.liteapp.d;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f
{
  private static String brand = null;
  public static boolean ehZ = true;
  private static String model = null;
  
  private static int C(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219078);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = g.ew(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      label46:
      break label46;
    }
    b.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(219078);
    return paramInt;
  }
  
  public static int anV()
  {
    return 48;
  }
  
  public static int be(Context paramContext)
  {
    AppMethodBeat.i(219069);
    int i = C(paramContext, e.bd(paramContext));
    AppMethodBeat.o(219069);
    return i;
  }
  
  private static Point bf(Context paramContext)
  {
    AppMethodBeat.i(219087);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(219087);
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
  
  public static boolean bg(Context paramContext)
  {
    AppMethodBeat.i(219092);
    if (bh(paramContext))
    {
      AppMethodBeat.o(219092);
      return false;
    }
    if (bi(paramContext) > 0)
    {
      AppMethodBeat.o(219092);
      return true;
    }
    AppMethodBeat.o(219092);
    return false;
  }
  
  private static boolean bh(Context paramContext)
  {
    AppMethodBeat.i(219106);
    for (;;)
    {
      try
      {
        if (isNullOrNil(brand)) {
          brand = Build.BRAND;
        }
        if (isNullOrNil(model)) {
          model = Build.MODEL;
        }
        if (!isNullOrNil(brand)) {
          brand = brand.toLowerCase();
        }
        if (!isNullOrNil(model)) {
          model = model.toLowerCase();
        }
        if ((!isNullOrNil(brand)) && ((brand.contains("huawei")) || (brand.contains("honor"))) && (model.contains("lio-an00m")))
        {
          ContentResolver localContentResolver = paramContext.getContentResolver();
          paramContext = brand;
          if (!isNullOrNil(paramContext))
          {
            if (paramContext.contains("huawei")) {
              break label276;
            }
            if (paramContext.contains("honor"))
            {
              break label276;
              if (Settings.Global.getInt(localContentResolver, paramContext, 0) == 0) {
                continue;
              }
              AppMethodBeat.o(219106);
              return true;
            }
            if ((paramContext.contains("xiaomi")) || (paramContext.contains("redmi"))) {
              break label282;
            }
            if (paramContext.contains("vivo"))
            {
              paramContext = "navigation_gesture_on";
              continue;
            }
            if (paramContext.contains("oppo"))
            {
              paramContext = "hide_navigationbar_enable";
              continue;
            }
            if (paramContext.contains("samsung"))
            {
              paramContext = "navigationbar_hide_bar_enabled";
              continue;
            }
            if (paramContext.contains("nokia"))
            {
              if (Build.VERSION.SDK_INT >= 28) {
                break label288;
              }
              paramContext = "navigation_bar_can_hiden";
              continue;
            }
          }
          paramContext = "navigationbar_is_min";
          continue;
          AppMethodBeat.o(219106);
          return false;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(219106);
        return false;
      }
      label276:
      paramContext = "navigationbar_is_min";
      continue;
      label282:
      paramContext = "force_fsg_nav_bar";
      continue;
      label288:
      paramContext = "swipe_up_to_switch_apps_enabled";
    }
  }
  
  private static int bi(Context paramContext)
  {
    AppMethodBeat.i(219130);
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = bf(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    if (bj(paramContext)) {
      i = ((Point)localObject1).y;
    }
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom, ((Rect)localObject1).right);
      if (bj(paramContext)) {
        i = ((Rect)localObject1).bottom;
      }
    }
    AppMethodBeat.o(219130);
    return j - i;
  }
  
  private static boolean bj(Context paramContext)
  {
    AppMethodBeat.i(219136);
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      AppMethodBeat.o(219136);
      return true;
    }
    AppMethodBeat.o(219136);
    return false;
  }
  
  public static int bk(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(219145);
    if (bg(paramContext))
    {
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = bi(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(219145);
      return j;
    }
    AppMethodBeat.o(219145);
    return 0;
  }
  
  private static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(219117);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(219117);
      return true;
    }
    AppMethodBeat.o(219117);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.d.f
 * JD-Core Version:    0.7.0.1
 */