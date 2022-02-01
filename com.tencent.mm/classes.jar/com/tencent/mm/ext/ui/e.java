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
import com.tencent.liteapp.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.b.c;
import java.lang.reflect.Method;

public final class e
{
  public static String jRE;
  private static Rect jRF;
  private static boolean jRG;
  private static SparseArray<WindowInsets> jRH;
  private static SparseArray<Rect> jRI;
  private static final Object jRJ;
  private static boolean jRK;
  private static boolean jRL;
  private static Boolean jRM;
  private static Boolean jRN;
  private static Boolean jRO;
  private static Boolean jRP;
  private static String jRQ;
  private static boolean jRR;
  private static boolean jRS;
  private static Boolean jRT;
  private static Boolean jRU;
  @TargetApi(26)
  private static Boolean jRV;
  private static Boolean jRW;
  private static Boolean jRX;
  
  static
  {
    AppMethodBeat.i(259027);
    jRE = "has_cutout";
    jRF = new Rect(0, 0, 0, 0);
    jRG = false;
    jRH = new SparseArray(4);
    jRI = new SparseArray(4);
    jRJ = new Object();
    jRK = false;
    jRL = false;
    jRM = null;
    jRN = null;
    jRO = null;
    jRP = null;
    jRQ = "xiaomi&28, redmi&28, samsung&28, vivo&28, oppo&29, huawei&29, honor&29, oneplus&29, meizu&24, smartisan&24, other&29";
    jRR = false;
    jRS = false;
    jRT = null;
    jRU = null;
    jRV = null;
    jRW = null;
    jRX = null;
    AppMethodBeat.o(259027);
  }
  
  private static ViewGroup a(Window paramWindow)
  {
    AppMethodBeat.i(259007);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow = new com.tencent.mm.ext.a.a.a(paramWindow, "mContentRoot");
      if (!paramWindow.avs()) {}
    }
    try
    {
      paramWindow = (ViewGroup)paramWindow.get();
      AppMethodBeat.o(259007);
      return paramWindow;
    }
    catch (NoSuchFieldException paramWindow)
    {
      com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", paramWindow.toString(), new Object[0]);
      AppMethodBeat.o(259007);
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
    AppMethodBeat.i(259005);
    if (paramWindow == null)
    {
      AppMethodBeat.o(259005);
      return null;
    }
    Object localObject = a(paramWindow);
    if (localObject != null)
    {
      AppMethodBeat.o(259005);
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
          AppMethodBeat.o(259005);
          return paramWindow;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.clearFlags(-2147483648);
        }
      }
      paramWindow = (ViewGroup)paramView;
      AppMethodBeat.o(259005);
      return paramWindow;
    }
  }
  
  private static boolean aEf()
  {
    AppMethodBeat.i(259019);
    if ((aEh()) && ((aEl()) || (aEi())) && (aEj()))
    {
      AppMethodBeat.o(259019);
      return true;
    }
    AppMethodBeat.o(259019);
    return false;
  }
  
  private static boolean aEg()
  {
    AppMethodBeat.i(259020);
    if ((aEh()) && ((aEl()) || (aEi())) && (Build.VERSION.SDK_INT >= 26))
    {
      AppMethodBeat.o(259020);
      return true;
    }
    AppMethodBeat.o(259020);
    return false;
  }
  
  private static boolean aEh()
  {
    AppMethodBeat.i(259021);
    if (jRM == null) {
      jRM = Boolean.TRUE;
    }
    boolean bool = jRM.booleanValue();
    AppMethodBeat.o(259021);
    return bool;
  }
  
  private static boolean aEi()
  {
    AppMethodBeat.i(259023);
    if (jRN == null) {}
    try
    {
      jRN = Boolean.FALSE;
      boolean bool = jRN.booleanValue();
      AppMethodBeat.o(259023);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.liteapp.b.b.e("MicroMsg.UIUtils", "isDarkModeUnusedOn %s", new Object[] { localException.toString() });
        jRN = Boolean.FALSE;
      }
    }
  }
  
  private static boolean aEj()
  {
    AppMethodBeat.i(259024);
    if (jRP == null)
    {
      jRP = Boolean.FALSE;
      try
      {
        com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test darkModeUsableBrandAPI: %s", new Object[] { "" });
        if (!TextUtils.isEmpty(""))
        {
          String str = Build.BRAND.toLowerCase();
          if (jRQ.contains(str))
          {
            String[] arrayOfString = "".split(",");
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label260;
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
              jRP = Boolean.TRUE;
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
          jRP = Boolean.TRUE;
        }
      }
    }
    label260:
    boolean bool = jRP.booleanValue();
    AppMethodBeat.o(259024);
    return bool;
  }
  
  private static boolean aEk()
  {
    if (!jRS)
    {
      jRR = false;
      jRS = true;
    }
    return jRR;
  }
  
  private static boolean aEl()
  {
    AppMethodBeat.i(259025);
    if (jRU == null) {
      jRU = Boolean.FALSE;
    }
    boolean bool = jRU.booleanValue();
    AppMethodBeat.o(259025);
    return bool;
  }
  
  public static int aM(Context paramContext)
  {
    AppMethodBeat.i(259011);
    int i = com.tencent.mm.ext.a.b.b.cD(paramContext);
    AppMethodBeat.o(259011);
    return i;
  }
  
  public static boolean aN(Context paramContext)
  {
    AppMethodBeat.i(259013);
    boolean bool = cE(paramContext);
    AppMethodBeat.o(259013);
    return bool;
  }
  
  public static Point au(Context paramContext)
  {
    AppMethodBeat.i(259009);
    Point localPoint = new Point();
    if (paramContext == null)
    {
      AppMethodBeat.o(259009);
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(259009);
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
  
  public static boolean cE(Context paramContext)
  {
    AppMethodBeat.i(259015);
    if ((c.vivohasCutOut(paramContext)) || (com.tencent.mm.ext.b.b.oppohasCutOut(paramContext)) || (com.tencent.mm.ext.b.a.huaweihasCutOut(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "hasCutOut:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(259015);
      return bool;
    }
  }
  
  public static boolean f(Resources paramResources)
  {
    AppMethodBeat.i(259018);
    if ((!aEg()) && (!aEf()))
    {
      AppMethodBeat.o(259018);
      return false;
    }
    if (aEk())
    {
      if (paramResources == null)
      {
        com.tencent.liteapp.b.b.i("MicroMsg.UIUtils", "dancy test is not darkmode, activity is null ", new Object[0]);
        AppMethodBeat.o(259018);
        return false;
      }
      switch (paramResources.getConfiguration().uiMode & 0x30)
      {
      default: 
        AppMethodBeat.o(259018);
        return false;
      case 16: 
        AppMethodBeat.o(259018);
        return false;
      }
      AppMethodBeat.o(259018);
      return true;
    }
    boolean bool = isDarkMode();
    AppMethodBeat.o(259018);
    return bool;
  }
  
  private static boolean isDarkMode()
  {
    AppMethodBeat.i(259016);
    if (aEk())
    {
      b.a locala = com.tencent.liteapp.b.cox;
      if ((f(b.a.getAppContext().getResources())) && (aEf()))
      {
        AppMethodBeat.o(259016);
        return true;
      }
      AppMethodBeat.o(259016);
      return false;
    }
    if (jRT == null) {
      jRT = Boolean.FALSE;
    }
    if ((jRT.booleanValue()) && ((aEg()) || (aEf())))
    {
      AppMethodBeat.o(259016);
      return true;
    }
    AppMethodBeat.o(259016);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.ui.e
 * JD-Core Version:    0.7.0.1
 */