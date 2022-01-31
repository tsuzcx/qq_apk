package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public enum l
{
  public static void A(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {}
    while ((Build.VERSION.SDK_INT < 21) || (((paramWindow.getAttributes().flags & 0x80000000) != 0) && (paramWindow.getStatusBarColor() == 0))) {
      return;
    }
    paramWindow.addFlags(-2147483648);
    paramWindow.setStatusBarColor(0);
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if ((paramWindow == null) || (paramWindow.getDecorView() == null)) {}
    while ((Build.VERSION.SDK_INT < 23) || ((b.zK()) && (b.zL()))) {
      return false;
    }
    paramWindow = paramWindow.getDecorView();
    int i = paramWindow.getSystemUiVisibility();
    if (paramBoolean) {
      i |= 0x2000;
    }
    for (;;)
    {
      paramWindow.setSystemUiVisibility(i);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  public static int[] api()
  {
    Display localDisplay = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
    return new int[] { localDisplay.getWidth(), localDisplay.getHeight() };
  }
  
  private static int b(Window paramWindow, boolean paramBoolean)
  {
    int i = paramWindow.getDecorView().getSystemUiVisibility();
    int j;
    if (paramBoolean)
    {
      j = i | 0x400 | 0x100;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j | 0x200 | 0x2;
      }
      j = i | 0x4;
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j | 0x1000;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", new Object[] { Integer.valueOf(i) });
      return i;
      j = i & 0xFFFFFBFF & 0xFFFFFEFF;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j & 0xFFFFFDFF & 0xFFFFFFFD;
      }
      j = i & 0xFFFFFFFB;
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j & 0xFFFFEFFF;
      }
    }
  }
  
  public static boolean b(Window paramWindow)
  {
    return a(paramWindow, true);
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
  
  public static void c(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i = b(paramWindow, true);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new l.1(paramWindow));
      paramWindow.addFlags(1024);
      return;
    }
    int i = b(paramWindow, false);
    paramWindow.getDecorView().setSystemUiVisibility(i);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    paramWindow.clearFlags(1024);
  }
  
  public static boolean c(Window paramWindow)
  {
    if ((paramWindow == null) || (paramWindow.getDecorView() == null)) {}
    while ((Build.VERSION.SDK_INT < 23) || ((paramWindow.getDecorView().getSystemUiVisibility() & 0x2000) == 0)) {
      return false;
    }
    return true;
  }
  
  public static Activity cx(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof ContextWrapper)) && (!(paramContext instanceof Activity))) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    for (;;)
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      return null;
    }
  }
  
  public static boolean s(Activity paramActivity)
  {
    return (Build.VERSION.SDK_INT >= 24) && (paramActivity != null) && (paramActivity.isInMultiWindowMode());
  }
  
  public static long wu(String paramString)
  {
    return x(paramString, -1L);
  }
  
  private static long x(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
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
    catch (Exception paramString)
    {
      y.e("MicroMsg.AppBrandUIUtil", "Failed to parse color: %s", new Object[] { localObject });
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */