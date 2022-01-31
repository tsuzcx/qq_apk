package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;

public final class v
{
  private static float density;
  private static final Method iYj;
  
  static
  {
    Object localObject = null;
    AppMethodBeat.i(87438);
    if (Build.VERSION.SDK_INT < 24) {}
    for (;;)
    {
      iYj = localObject;
      density = -1.0F;
      AppMethodBeat.o(87438);
      return;
      try
      {
        Method localMethod = Activity.class.getMethod("isInMultiWindowMode", new Class[0]);
        localObject = localMethod;
      }
      catch (Exception localException) {}
    }
  }
  
  private static long G(String paramString, long paramLong)
  {
    AppMethodBeat.i(87432);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(87432);
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
      paramLong = i;
      AppMethodBeat.o(87432);
      return 0xFFFFFFFF & paramLong;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(87432);
    }
    return paramLong;
  }
  
  public static int by(String paramString, int paramInt)
  {
    AppMethodBeat.i(87431);
    paramInt = (int)G(paramString, paramInt);
    AppMethodBeat.o(87431);
    return paramInt;
  }
  
  public static boolean cy(View paramView)
  {
    AppMethodBeat.i(87433);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(87433);
      return false;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(87433);
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
    if (((paramView instanceof Activity)) && (u((Activity)paramView)))
    {
      AppMethodBeat.o(87433);
      return true;
    }
    AppMethodBeat.o(87433);
    return false;
  }
  
  public static int[] d(h paramh)
  {
    AppMethodBeat.i(87437);
    d locald = paramh.getRuntime().gPC;
    if (locald.isLaidOut())
    {
      i = locald.getMeasuredWidth();
      j = locald.getMeasuredHeight();
      AppMethodBeat.o(87437);
      return new int[] { i, j };
    }
    paramh = paramh.getContext().getResources().getDisplayMetrics();
    int i = paramh.widthPixels;
    int j = paramh.heightPixels;
    AppMethodBeat.o(87437);
    return new int[] { i, j };
  }
  
  public static int[] dh(Context paramContext)
  {
    AppMethodBeat.i(87435);
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i = paramContext.getWidth();
    int j = paramContext.getHeight();
    AppMethodBeat.o(87435);
    return new int[] { i, j };
  }
  
  public static int[] n(r paramr)
  {
    AppMethodBeat.i(87436);
    Object localObject = paramr.getCurrentPageView();
    if (localObject == null) {}
    for (localObject = null; (localObject != null) && (((View)localObject).isLaidOut()); localObject = ((com.tencent.mm.plugin.appbrand.page.v)localObject).ivI)
    {
      ab.i("UIUtil", "Method: normal");
      i = ((View)localObject).getWidth();
      j = ((View)localObject).getHeight();
      AppMethodBeat.o(87436);
      return new int[] { i, j };
    }
    if ((paramr.getContext() instanceof Activity))
    {
      ab.i("UIUtil", "Method: DecorView");
      localObject = ((Activity)paramr.getContext()).getWindow().getDecorView();
      Rect localRect = new Rect();
      ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      i = localRect.right;
      j = localRect.left;
      int k = localRect.bottom;
      int m = localRect.top;
      int n = a.fromDPToPix(paramr.getContext(), 48);
      AppMethodBeat.o(87436);
      return new int[] { i - j, k - m - n };
    }
    ab.i("UIUtil", "Method: Screen");
    int i = paramr.getContext().getResources().getDisplayMetrics().widthPixels;
    int j = paramr.getContext().getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(87436);
    return new int[] { i, j };
  }
  
  private static boolean u(Activity paramActivity)
  {
    AppMethodBeat.i(87434);
    try
    {
      Method localMethod = iYj;
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        boolean bool = ((Boolean)localMethod.invoke(paramActivity, new Object[0])).booleanValue();
        AppMethodBeat.o(87434);
        return bool;
      }
      ab.d("UIUtil", "isInMultiWindowMode method null");
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        ab.d("UIUtil", "isInMultiWindowMode, exp %s", new Object[] { paramActivity });
      }
    }
    AppMethodBeat.o(87434);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.v
 * JD-Core Version:    0.7.0.1
 */