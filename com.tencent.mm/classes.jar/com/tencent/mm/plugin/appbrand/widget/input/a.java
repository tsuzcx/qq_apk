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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.t;
import java.lang.reflect.Method;

public final class a
{
  public static final boolean rtG;
  public final Activity activity;
  public boolean rtH = false;
  public int rtI = 0;
  
  static
  {
    if (Build.VERSION.SDK_INT < 20) {}
    for (boolean bool = true;; bool = false)
    {
      rtG = bool;
      return;
    }
  }
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private boolean cnW()
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
  
  public static boolean cnX()
  {
    AppMethodBeat.i(136302);
    try
    {
      boolean bool = ((Boolean)org.a.a.gY(org.a.a.ce(org.a.a.bIA("android.view.WindowManagerGlobal")).bIz("getWindowManagerService").object).bIz("hasNavigationBar").object).booleanValue();
      AppMethodBeat.o(136302);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrandFixInputIssuesActivityHelper", "checkDeviceHasNavigationBar2 e=%s", new Object[] { localThrowable });
      AppMethodBeat.o(136302);
    }
    return false;
  }
  
  public static boolean eB(Context paramContext)
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
  
  public final void cnU()
  {
    AppMethodBeat.i(136298);
    if ((!this.rtH) || (this.activity.isFinishing()))
    {
      AppMethodBeat.o(136298);
      return;
    }
    if (rtG)
    {
      if (n.I(this.activity) == null)
      {
        Log.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
        AppMethodBeat.o(136298);
        return;
      }
      cnV();
    }
    AppMethodBeat.o(136298);
  }
  
  public final void cnV()
  {
    AppMethodBeat.i(183096);
    n localn = n.I(this.activity);
    Point localPoint = new Point();
    this.activity.getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = t.kI(this.activity);
    int j = localPoint.y;
    if (cnW()) {
      i = 0;
    }
    i = j - i;
    Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[] { Integer.valueOf(i) });
    localn.setForceHeight(i);
    AppMethodBeat.o(183096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a
 * JD-Core Version:    0.7.0.1
 */