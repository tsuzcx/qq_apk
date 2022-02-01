package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.q;
import java.lang.reflect.Method;

public final class a
{
  public static final boolean mCh;
  public final Activity activity;
  public boolean mCi = false;
  public int mCj = 0;
  
  static
  {
    if (Build.VERSION.SDK_INT < 20) {}
    for (boolean bool = true;; bool = false)
    {
      mCh = bool;
      return;
    }
  }
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private boolean bzG()
  {
    AppMethodBeat.i(136300);
    if ((this.activity.getWindow() != null) && ((this.activity.getWindow().getAttributes().flags & 0x400) > 0))
    {
      AppMethodBeat.o(136300);
      return true;
    }
    AppMethodBeat.o(136300);
    return false;
  }
  
  public static boolean bzH()
  {
    AppMethodBeat.i(136302);
    try
    {
      boolean bool = ((Boolean)org.a.a.gc(org.a.a.bD(org.a.a.forName("android.view.WindowManagerGlobal")).aXD("getWindowManagerService").object).aXD("hasNavigationBar").object).booleanValue();
      AppMethodBeat.o(136302);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AppBrandFixInputIssuesActivityHelper", "checkDeviceHasNavigationBar2 e=%s", new Object[] { localThrowable });
      AppMethodBeat.o(136302);
    }
    return false;
  }
  
  public static boolean ee(Context paramContext)
  {
    AppMethodBeat.i(136301);
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i > 0) {}
    for (boolean bool1 = paramContext.getBoolean(i);; bool1 = false) {
      for (;;)
      {
        try
        {
          paramContext = Class.forName("android.os.SystemProperties");
          paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
          bool2 = "1".equals(paramContext);
          if (!bool2) {
            continue;
          }
          bool1 = false;
        }
        catch (Exception paramContext)
        {
          boolean bool2;
          continue;
        }
        AppMethodBeat.o(136301);
        return bool1;
        bool2 = "0".equals(paramContext);
        if (!bool2) {
          continue;
        }
        bool1 = true;
      }
    }
  }
  
  public final void bzE()
  {
    AppMethodBeat.i(136298);
    if ((!this.mCi) || (this.activity.isFinishing()))
    {
      AppMethodBeat.o(136298);
      return;
    }
    if (mCh)
    {
      if (n.H(this.activity) == null)
      {
        ac.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
        AppMethodBeat.o(136298);
        return;
      }
      bzF();
    }
    AppMethodBeat.o(136298);
  }
  
  public final void bzF()
  {
    AppMethodBeat.i(183096);
    n localn = n.H(this.activity);
    Point localPoint = new Point();
    this.activity.getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = q.jw(this.activity);
    int j = localPoint.y;
    if (bzG()) {
      i = 0;
    }
    i = j - i;
    ac.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[] { Integer.valueOf(i) });
    localn.setForceHeight(i);
    AppMethodBeat.o(183096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a
 * JD-Core Version:    0.7.0.1
 */