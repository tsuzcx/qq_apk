package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.q;

public final class r
  extends q
{
  static int a(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(135330);
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
      ac.i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(135330);
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
  
  public static void a(Window paramWindow, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176775);
    if (paramBoolean1)
    {
      i = a(paramWindow, true);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(176773);
          ac.d("MicroMsg.AppBrandUIUtil", "visibility = ".concat(String.valueOf(paramAnonymousInt)));
          if ((paramAnonymousInt & 0x4) == 0) {
            this.kNp.getDecorView().setSystemUiVisibility(r.a(this.kNp, true));
          }
          AppMethodBeat.o(176773);
        }
      });
      paramWindow.addFlags(1024);
      if ((paramBoolean2) && (Build.VERSION.SDK_INT >= 28))
      {
        paramWindow.getAttributes().layoutInDisplayCutoutMode = 1;
        paramWindow.setAttributes(paramWindow.getAttributes());
      }
      AppMethodBeat.o(176775);
      return;
    }
    int i = a(paramWindow, false);
    paramWindow.getDecorView().setSystemUiVisibility(i);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    try
    {
      paramWindow.clearFlags(1024);
      AppMethodBeat.o(176775);
      return;
    }
    catch (Exception paramWindow)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandUIUtil", paramWindow, "[CAUGHT CRASH]", new Object[0]);
      AppMethodBeat.o(176775);
    }
  }
  
  public static boolean cM(View paramView)
  {
    AppMethodBeat.i(135329);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(135329);
      return false;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(135329);
      return false;
    }
    paramView = a.jg(paramView.getContext());
    if ((paramView != null) && (paramView.isInMultiWindowMode()))
    {
      AppMethodBeat.o(135329);
      return true;
    }
    AppMethodBeat.o(135329);
    return false;
  }
  
  public static boolean dQ(Context paramContext)
  {
    AppMethodBeat.i(178640);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(178640);
      return false;
    }
    try
    {
      if ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) == 1024)
      {
        AppMethodBeat.o(178640);
        return true;
      }
      AppMethodBeat.o(178640);
      return false;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(178640);
    }
    return false;
  }
  
  public static void s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(176774);
    Activity localActivity = a.jg(paramContext);
    if ((localActivity != null) && (localActivity.getWindow() != null))
    {
      a(localActivity.getWindow(), paramBoolean, false);
      AppMethodBeat.o(176774);
      return;
    }
    ac.w("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", new Object[] { paramContext });
    AppMethodBeat.o(176774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.r
 * JD-Core Version:    0.7.0.1
 */