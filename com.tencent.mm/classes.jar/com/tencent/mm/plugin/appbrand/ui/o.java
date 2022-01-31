package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.af;

public enum o
{
  @Deprecated
  public static void a(Window paramWindow)
  {
    AppMethodBeat.i(87384);
    af.a(paramWindow);
    AppMethodBeat.o(87384);
  }
  
  @Deprecated
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(87385);
    paramBoolean = af.a(paramWindow, paramBoolean);
    AppMethodBeat.o(87385);
    return paramBoolean;
  }
  
  public static int[] aMu()
  {
    AppMethodBeat.i(87383);
    Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(87383);
    return new int[] { i, j };
  }
  
  private static int b(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(87390);
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
      ab.i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(87390);
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
    AppMethodBeat.i(87386);
    if ((paramWindow == null) || (paramWindow.getDecorView() == null))
    {
      AppMethodBeat.o(87386);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0))
    {
      AppMethodBeat.o(87386);
      return true;
    }
    AppMethodBeat.o(87386);
    return false;
  }
  
  public static void c(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(87392);
    if (paramBoolean)
    {
      i = b(paramWindow, true);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new o.1(paramWindow));
      paramWindow.addFlags(1024);
      AppMethodBeat.o(87392);
      return;
    }
    int i = b(paramWindow, false);
    paramWindow.getDecorView().setSystemUiVisibility(i);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    paramWindow.clearFlags(1024);
    AppMethodBeat.o(87392);
  }
  
  public static boolean cy(View paramView)
  {
    AppMethodBeat.i(87389);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(87389);
      return false;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(87389);
      return false;
    }
    paramView = a.hr(paramView.getContext());
    if ((paramView != null) && (paramView.isInMultiWindowMode()))
    {
      AppMethodBeat.o(87389);
      return true;
    }
    AppMethodBeat.o(87389);
    return false;
  }
  
  public static void de(Context paramContext)
  {
    AppMethodBeat.i(141711);
    Activity localActivity = a.hr(paramContext);
    if ((localActivity != null) && (localActivity.getWindow() != null))
    {
      c(localActivity.getWindow(), true);
      AppMethodBeat.o(141711);
      return;
    }
    ab.w("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", new Object[] { paramContext });
    AppMethodBeat.o(141711);
  }
  
  public static boolean u(Activity paramActivity)
  {
    AppMethodBeat.i(87387);
    if ((Build.VERSION.SDK_INT >= 24) && (paramActivity != null) && (paramActivity.isInMultiWindowMode()))
    {
      AppMethodBeat.o(87387);
      return true;
    }
    AppMethodBeat.o(87387);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o
 * JD-Core Version:    0.7.0.1
 */