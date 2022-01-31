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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
import java.lang.reflect.Method;

public final class a
{
  public static final boolean jku;
  public final Activity activity;
  public boolean jkv = false;
  public int jkw = 0;
  
  static
  {
    if (Build.VERSION.SDK_INT < 20) {}
    for (boolean bool = true;; bool = false)
    {
      jku = bool;
      return;
    }
  }
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private boolean aQq()
  {
    AppMethodBeat.i(123570);
    if ((this.activity.getWindow() != null) && ((this.activity.getWindow().getAttributes().flags & 0x400) > 0))
    {
      AppMethodBeat.o(123570);
      return true;
    }
    AppMethodBeat.o(123570);
    return false;
  }
  
  public static boolean aQr()
  {
    AppMethodBeat.i(141600);
    try
    {
      boolean bool = ((Boolean)org.a.a.ep(org.a.a.ba(org.a.a.forName("android.view.WindowManagerGlobal")).azS("getWindowManagerService").object).azS("hasNavigationBar").object).booleanValue();
      AppMethodBeat.o(141600);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.AppBrandFixInputIssuesActivityHelper", "checkDeviceHasNavigationBar2 e=%s", new Object[] { localThrowable });
      AppMethodBeat.o(141600);
    }
    return false;
  }
  
  public static boolean du(Context paramContext)
  {
    AppMethodBeat.i(123571);
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
        AppMethodBeat.o(123571);
        return bool1;
        bool2 = "0".equals(paramContext);
        if (!bool2) {
          continue;
        }
        bool1 = true;
      }
    }
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(123569);
    Point localPoint = new Point();
    this.activity.getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = af.hT(this.activity);
    int j = localPoint.y;
    if (aQq()) {
      i = 0;
    }
    i = j - i;
    ab.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[] { Integer.valueOf(i) });
    paramn.setForceHeight(i);
    AppMethodBeat.o(123569);
  }
  
  public final void aQp()
  {
    AppMethodBeat.i(123568);
    if ((!this.jkv) || (this.activity.isFinishing()))
    {
      AppMethodBeat.o(123568);
      return;
    }
    if (jku)
    {
      n localn = n.v(this.activity);
      if (localn == null)
      {
        ab.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
        AppMethodBeat.o(123568);
        return;
      }
      a(localn);
    }
    AppMethodBeat.o(123568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a
 * JD-Core Version:    0.7.0.1
 */