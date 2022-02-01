package com.tencent.mm.ext.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.liteapp.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.b.a;
import com.tencent.mm.ext.b.c;
import java.lang.reflect.Method;

public final class e
{
  public static String mqO;
  private static Rect mqP;
  private static boolean mqQ;
  private static SparseArray<WindowInsets> mqR;
  private static SparseArray<Rect> mqS;
  private static final Object mqT;
  private static boolean mqU;
  private static boolean mqV;
  private static Boolean mqW;
  private static Boolean mqX;
  private static Boolean mqY;
  private static Boolean mqZ;
  private static String mra;
  private static boolean mrb;
  private static boolean mrc;
  private static Boolean mrd;
  private static Boolean mre;
  private static Boolean mrf;
  private static Boolean mrg;
  private static Boolean mrh;
  
  static
  {
    AppMethodBeat.i(235436);
    mqO = "has_cutout";
    mqP = new Rect(0, 0, 0, 0);
    mqQ = false;
    mqR = new SparseArray(4);
    mqS = new SparseArray(4);
    mqT = new Object();
    mqU = false;
    mqV = false;
    mqW = null;
    mqX = null;
    mqY = null;
    mqZ = null;
    mra = "xiaomi&28, redmi&28, samsung&28, vivo&28, oppo&29, huawei&29, honor&29, oneplus&29, meizu&24, smartisan&24, other&29";
    mrb = false;
    mrc = false;
    mrd = null;
    mre = null;
    mrf = null;
    mrg = null;
    mrh = null;
    AppMethodBeat.o(235436);
  }
  
  private static ViewGroup a(Window paramWindow)
  {
    AppMethodBeat.i(235346);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow = new com.tencent.mm.ext.a.a.b(paramWindow, "mContentRoot");
      if (!paramWindow.aPM()) {}
    }
    try
    {
      paramWindow = (ViewGroup)paramWindow.get();
      AppMethodBeat.o(235346);
      return paramWindow;
    }
    catch (NoSuchFieldException paramWindow)
    {
      com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", paramWindow.toString(), new Object[0]);
      AppMethodBeat.o(235346);
      return null;
    }
    catch (IllegalAccessException paramWindow)
    {
      break label47;
    }
    catch (IllegalArgumentException paramWindow)
    {
      label47:
      break label47;
    }
  }
  
  public static ViewGroup a(Window paramWindow, View paramView)
  {
    View localView = null;
    AppMethodBeat.i(235340);
    if (paramWindow == null)
    {
      AppMethodBeat.o(235340);
      return null;
    }
    Object localObject = a(paramWindow);
    if (localObject != null)
    {
      AppMethodBeat.o(235340);
      return localObject;
    }
    if (paramView != null) {
      for (paramView = paramView.getParent(); (paramView != paramWindow.getDecorView()) && (paramView != null); paramView = (View)localObject)
      {
        localObject = paramView.getParent();
        localView = paramView;
      }
    }
    for (paramView = localView;; paramView = null)
    {
      if (paramView == null)
      {
        localView = ((ViewGroup)paramWindow.getDecorView()).getChildAt(0);
        if ((localView instanceof ViewGroup))
        {
          paramWindow = (ViewGroup)localView;
          AppMethodBeat.o(235340);
          return paramWindow;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.clearFlags(-2147483648);
        }
      }
      paramWindow = (ViewGroup)paramView;
      AppMethodBeat.o(235340);
      return paramWindow;
    }
  }
  
  private static boolean aXj()
  {
    AppMethodBeat.i(235387);
    if ((aXl()) && ((aXp()) || (aXm())) && (aXn()))
    {
      AppMethodBeat.o(235387);
      return true;
    }
    AppMethodBeat.o(235387);
    return false;
  }
  
  private static boolean aXk()
  {
    AppMethodBeat.i(235394);
    if ((aXl()) && ((aXp()) || (aXm())) && (Build.VERSION.SDK_INT >= 26))
    {
      AppMethodBeat.o(235394);
      return true;
    }
    AppMethodBeat.o(235394);
    return false;
  }
  
  private static boolean aXl()
  {
    AppMethodBeat.i(235399);
    if (mqW == null) {
      mqW = Boolean.TRUE;
    }
    boolean bool = mqW.booleanValue();
    AppMethodBeat.o(235399);
    return bool;
  }
  
  private static boolean aXm()
  {
    AppMethodBeat.i(235406);
    if (mqX == null) {}
    try
    {
      mqX = Boolean.FALSE;
      boolean bool = mqX.booleanValue();
      AppMethodBeat.o(235406);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", "isDarkModeUnusedOn %s", new Object[] { localException.toString() });
        mqX = Boolean.FALSE;
      }
    }
  }
  
  private static boolean aXn()
  {
    AppMethodBeat.i(235416);
    if (mqZ == null)
    {
      mqZ = Boolean.FALSE;
      try
      {
        com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test darkModeUsableBrandAPI: %s", new Object[] { "" });
        if (!TextUtils.isEmpty(""))
        {
          String str = Build.BRAND.toLowerCase();
          if (mra.contains(str))
          {
            String[] arrayOfString = "".split(",");
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label259;
            }
            localObject = arrayOfString[i];
            if (((String)localObject).contains(str))
            {
              com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test usable brandAPI: %s", new Object[] { localObject });
              localObject = ((String)localObject).split("&");
              if ((localObject.length < 2) || (TextUtils.isEmpty(localObject[1]))) {}
            }
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            int i;
            Object localObject;
            int k = Integer.parseInt(localObject[1]);
            com.tencent.liteapp.b.b.d("MicroMsg.UIUtils", "dancy test api: %s", new Object[] { Integer.valueOf(k) });
            if (Build.VERSION.SDK_INT >= k) {
              mqZ = Boolean.TRUE;
            }
            i += 1;
          }
          localException = localException;
          com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", "darModeUsableBrandAPI %s", new Object[] { localException.toString() });
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", "parse api error! %s", new Object[] { localNumberFormatException.toString() });
          }
        }
        if (("".contains("other")) && (Build.VERSION.SDK_INT >= 29)) {
          mqZ = Boolean.TRUE;
        }
      }
    }
    label259:
    boolean bool = mqZ.booleanValue();
    AppMethodBeat.o(235416);
    return bool;
  }
  
  private static boolean aXo()
  {
    if (!mrc)
    {
      mrb = false;
      mrc = true;
    }
    return mrb;
  }
  
  private static boolean aXp()
  {
    AppMethodBeat.i(235427);
    if (mre == null) {
      mre = Boolean.FALSE;
    }
    boolean bool = mre.booleanValue();
    AppMethodBeat.o(235427);
    return bool;
  }
  
  public static Point bf(Context paramContext)
  {
    AppMethodBeat.i(235354);
    Point localPoint = new Point();
    if (paramContext == null)
    {
      AppMethodBeat.o(235354);
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(235354);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {
        try
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        }
        catch (Exception localException) {}
      } else {
        paramContext.getSize(localPoint);
      }
    }
  }
  
  public static int bw(Context paramContext)
  {
    AppMethodBeat.i(235358);
    int i = com.tencent.mm.ext.a.b.b.dr(paramContext);
    AppMethodBeat.o(235358);
    return i;
  }
  
  public static boolean bx(Context paramContext)
  {
    AppMethodBeat.i(235365);
    boolean bool = ds(paramContext);
    AppMethodBeat.o(235365);
    return bool;
  }
  
  public static boolean ds(Context paramContext)
  {
    AppMethodBeat.i(235372);
    if ((c.vivohasCutOut(paramContext)) || (com.tencent.mm.ext.b.b.oppohasCutOut(paramContext)) || (a.huaweihasCutOut(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "hasCutOut:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(235372);
      return bool;
    }
  }
  
  public static boolean f(Resources paramResources)
  {
    AppMethodBeat.i(235382);
    if ((!aXk()) && (!aXj()))
    {
      AppMethodBeat.o(235382);
      return false;
    }
    if (aXo())
    {
      if (paramResources == null)
      {
        com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test is not darkmode, activity is null ", new Object[0]);
        AppMethodBeat.o(235382);
        return false;
      }
      switch (paramResources.getConfiguration().uiMode & 0x30)
      {
      default: 
        AppMethodBeat.o(235382);
        return false;
      case 16: 
        AppMethodBeat.o(235382);
        return false;
      }
      AppMethodBeat.o(235382);
      return true;
    }
    boolean bool = isDarkMode();
    AppMethodBeat.o(235382);
    return bool;
  }
  
  private static boolean isDarkMode()
  {
    AppMethodBeat.i(235379);
    if (aXo())
    {
      b.a locala = com.tencent.liteapp.b.efD;
      if ((f(b.a.getAppContext().getResources())) && (aXj()))
      {
        AppMethodBeat.o(235379);
        return true;
      }
      AppMethodBeat.o(235379);
      return false;
    }
    if (mrd == null) {
      mrd = Boolean.FALSE;
    }
    if ((mrd.booleanValue()) && ((aXk()) || (aXj())))
    {
      AppMethodBeat.o(235379);
      return true;
    }
    AppMethodBeat.o(235379);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.ui.e
 * JD-Core Version:    0.7.0.1
 */