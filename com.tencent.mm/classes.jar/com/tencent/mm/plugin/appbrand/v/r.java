package com.tencent.mm.plugin.appbrand.v;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;

public final class r
{
  private static float density;
  private static final Method hlI;
  
  static
  {
    Object localObject = null;
    if (Build.VERSION.SDK_INT < 24) {}
    for (;;)
    {
      hlI = localObject;
      density = -1.0F;
      return;
      try
      {
        Method localMethod = Activity.class.getMethod("isInMultiWindowMode", new Class[0]);
        localObject = localMethod;
      }
      catch (Exception localException) {}
    }
  }
  
  public static boolean bW(View paramView)
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    if (paramView == null) {
      return false;
    }
    Context localContext = paramView.getContext();
    paramView = localContext;
    if ((localContext instanceof ContextWrapper))
    {
      paramView = localContext;
      if (!(localContext instanceof Activity)) {
        paramView = ((ContextWrapper)localContext).getBaseContext();
      }
    }
    return ((paramView instanceof Activity)) && (s((Activity)paramView));
  }
  
  public static int bb(String paramString, int paramInt)
  {
    return (int)x(paramString, Long.valueOf(paramInt).longValue());
  }
  
  public static int[] i(o paramo)
  {
    Object localObject = paramo.E(q.class);
    if (localObject == null) {}
    for (localObject = null; (localObject != null) && (((View)localObject).isLaidOut()); localObject = ((q)localObject).aha())
    {
      y.i("UIUtil", "Method: normal");
      return new int[] { ((View)localObject).getWidth(), ((View)localObject).getHeight() };
    }
    if ((paramo.getContext() instanceof Activity))
    {
      y.i("UIUtil", "Method: DecorView");
      localObject = ((Activity)paramo.getContext()).getWindow().getDecorView();
      Rect localRect = new Rect();
      ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      return new int[] { localRect.right - localRect.left, localRect.bottom - localRect.top - a.fromDPToPix(paramo.getContext(), 48) };
    }
    y.i("UIUtil", "Method: Screen");
    return new int[] { paramo.getContext().getResources().getDisplayMetrics().widthPixels, paramo.getContext().getResources().getDisplayMetrics().heightPixels };
  }
  
  public static int[] j(o paramo)
  {
    FrameLayout localFrameLayout = paramo.getRuntime().fyq;
    if (localFrameLayout.isLaidOut()) {
      return new int[] { localFrameLayout.getMeasuredWidth(), localFrameLayout.getMeasuredHeight() };
    }
    paramo = paramo.getContext().getResources().getDisplayMetrics();
    return new int[] { paramo.widthPixels, paramo.heightPixels };
  }
  
  private static boolean s(Activity paramActivity)
  {
    try
    {
      Method localMethod = hlI;
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        return ((Boolean)localMethod.invoke(paramActivity, new Object[0])).booleanValue();
      }
      y.d("UIUtil", "isInMultiWindowMode method null");
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        y.d("UIUtil", "isInMultiWindowMode, exp %s", new Object[] { paramActivity });
      }
    }
    return false;
  }
  
  private static long x(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramLong;
    }
    Object localObject = paramString;
    if (paramString.startsWith("#"))
    {
      localObject = paramString;
      if (paramString.length() == 4)
      {
        localObject = new StringBuilder(paramString);
        ((StringBuilder)localObject).insert(2, paramString.charAt(1));
        ((StringBuilder)localObject).insert(4, paramString.charAt(2));
        ((StringBuilder)localObject).insert(6, paramString.charAt(3));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    try
    {
      int i = Color.parseColor((String)localObject);
      return 0xFFFFFFFF & i;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.r
 * JD-Core Version:    0.7.0.1
 */