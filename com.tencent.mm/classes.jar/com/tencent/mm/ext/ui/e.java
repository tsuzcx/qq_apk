package com.tencent.mm.ext.ui;

import android.annotation.TargetApi;
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
import com.tencent.liteapp.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.b.c;
import java.lang.reflect.Method;

public final class e
{
  public static String hfM;
  private static Rect hfN;
  private static boolean hfO;
  private static SparseArray<WindowInsets> hfP;
  private static SparseArray<Rect> hfQ;
  private static final Object hfR;
  private static boolean hfS;
  private static boolean hfT;
  private static Boolean hfU;
  private static Boolean hfV;
  private static Boolean hfW;
  private static Boolean hfX;
  private static String hfY;
  private static boolean hfZ;
  private static boolean hga;
  private static Boolean hgb;
  private static Boolean hgc;
  @TargetApi(26)
  private static Boolean hgd;
  private static Boolean hge;
  private static Boolean hgf;
  
  static
  {
    AppMethodBeat.i(197878);
    hfM = "has_cutout";
    hfN = new Rect(0, 0, 0, 0);
    hfO = false;
    hfP = new SparseArray(4);
    hfQ = new SparseArray(4);
    hfR = new Object();
    hfS = false;
    hfT = false;
    hfU = null;
    hfV = null;
    hfW = null;
    hfX = null;
    hfY = "xiaomi&28, redmi&28, samsung&28, vivo&28, oppo&29, huawei&29, honor&29, oneplus&29, meizu&24, smartisan&24, other&29";
    hfZ = false;
    hga = false;
    hgb = null;
    hgc = null;
    hgd = null;
    hge = null;
    hgf = null;
    AppMethodBeat.o(197878);
  }
  
  private static ViewGroup a(Window paramWindow)
  {
    AppMethodBeat.i(197865);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow = new com.tencent.mm.ext.a.a.a(paramWindow, "mContentRoot");
      if (!paramWindow.apg()) {}
    }
    try
    {
      paramWindow = (ViewGroup)paramWindow.get();
      AppMethodBeat.o(197865);
      return paramWindow;
    }
    catch (NoSuchFieldException paramWindow)
    {
      com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", paramWindow.toString(), new Object[0]);
      AppMethodBeat.o(197865);
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
  
  @TargetApi(21)
  public static ViewGroup a(Window paramWindow, View paramView)
  {
    View localView = null;
    AppMethodBeat.i(197864);
    if (paramWindow == null)
    {
      AppMethodBeat.o(197864);
      return null;
    }
    Object localObject = a(paramWindow);
    if (localObject != null)
    {
      AppMethodBeat.o(197864);
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
          AppMethodBeat.o(197864);
          return paramWindow;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.clearFlags(-2147483648);
        }
      }
      paramWindow = (ViewGroup)paramView;
      AppMethodBeat.o(197864);
      return paramWindow;
    }
  }
  
  public static int aP(Context paramContext)
  {
    AppMethodBeat.i(197867);
    int i = com.tencent.mm.ext.a.b.b.cH(paramContext);
    AppMethodBeat.o(197867);
    return i;
  }
  
  public static boolean aQ(Context paramContext)
  {
    AppMethodBeat.i(197868);
    boolean bool = cI(paramContext);
    AppMethodBeat.o(197868);
    return bool;
  }
  
  private static boolean awN()
  {
    AppMethodBeat.i(197872);
    if ((awP()) && ((awT()) || (awQ())) && (awR()))
    {
      AppMethodBeat.o(197872);
      return true;
    }
    AppMethodBeat.o(197872);
    return false;
  }
  
  private static boolean awO()
  {
    AppMethodBeat.i(197873);
    if ((awP()) && ((awT()) || (awQ())) && (Build.VERSION.SDK_INT >= 26))
    {
      AppMethodBeat.o(197873);
      return true;
    }
    AppMethodBeat.o(197873);
    return false;
  }
  
  private static boolean awP()
  {
    AppMethodBeat.i(197874);
    if (hfU == null) {
      hfU = Boolean.TRUE;
    }
    boolean bool = hfU.booleanValue();
    AppMethodBeat.o(197874);
    return bool;
  }
  
  private static boolean awQ()
  {
    AppMethodBeat.i(197875);
    if (hfV == null) {}
    try
    {
      hfV = Boolean.FALSE;
      boolean bool = hfV.booleanValue();
      AppMethodBeat.o(197875);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", "isDarkModeUnusedOn %s", new Object[] { localException.toString() });
        hfV = Boolean.FALSE;
      }
    }
  }
  
  private static boolean awR()
  {
    AppMethodBeat.i(197876);
    if (hfX == null)
    {
      hfX = Boolean.FALSE;
      try
      {
        com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test darkModeUsableBrandAPI: %s", new Object[] { "" });
        if (!TextUtils.isEmpty(""))
        {
          String str = Build.BRAND.toLowerCase();
          if (hfY.contains(str))
          {
            String[] arrayOfString = "".split(",");
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label262;
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
              hfX = Boolean.TRUE;
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
          hfX = Boolean.TRUE;
        }
      }
    }
    label262:
    boolean bool = hfX.booleanValue();
    AppMethodBeat.o(197876);
    return bool;
  }
  
  private static boolean awS()
  {
    if (!hga)
    {
      hfZ = false;
      hga = true;
    }
    return hfZ;
  }
  
  private static boolean awT()
  {
    AppMethodBeat.i(197877);
    if (hgc == null) {
      hgc = Boolean.FALSE;
    }
    boolean bool = hgc.booleanValue();
    AppMethodBeat.o(197877);
    return bool;
  }
  
  public static Point az(Context paramContext)
  {
    AppMethodBeat.i(197866);
    Point localPoint = new Point();
    if (paramContext == null)
    {
      AppMethodBeat.o(197866);
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(197866);
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
  
  public static boolean cI(Context paramContext)
  {
    AppMethodBeat.i(197869);
    if ((c.vivohasCutOut(paramContext)) || (com.tencent.mm.ext.b.b.oppohasCutOut(paramContext)) || (com.tencent.mm.ext.b.a.huaweihasCutOut(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "hasCutOut:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(197869);
      return bool;
    }
  }
  
  public static boolean f(Resources paramResources)
  {
    AppMethodBeat.i(197871);
    if ((!awO()) && (!awN()))
    {
      AppMethodBeat.o(197871);
      return false;
    }
    if (awS())
    {
      if (paramResources == null)
      {
        com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test is not darkmode, activity is null ", new Object[0]);
        AppMethodBeat.o(197871);
        return false;
      }
      switch (paramResources.getConfiguration().uiMode & 0x30)
      {
      default: 
        AppMethodBeat.o(197871);
        return false;
      case 16: 
        AppMethodBeat.o(197871);
        return false;
      }
      AppMethodBeat.o(197871);
      return true;
    }
    boolean bool = isDarkMode();
    AppMethodBeat.o(197871);
    return bool;
  }
  
  private static boolean isDarkMode()
  {
    AppMethodBeat.i(197870);
    if (awS())
    {
      a.a locala = com.tencent.liteapp.a.cqJ;
      if ((f(a.a.getAppContext().getResources())) && (awN()))
      {
        AppMethodBeat.o(197870);
        return true;
      }
      AppMethodBeat.o(197870);
      return false;
    }
    if (hgb == null) {
      hgb = Boolean.FALSE;
    }
    if ((hgb.booleanValue()) && ((awO()) || (awN())))
    {
      AppMethodBeat.o(197870);
      return true;
    }
    AppMethodBeat.o(197870);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ext.ui.e
 * JD-Core Version:    0.7.0.1
 */