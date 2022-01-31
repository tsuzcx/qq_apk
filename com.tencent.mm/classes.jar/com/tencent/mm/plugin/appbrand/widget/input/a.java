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
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import java.lang.reflect.Method;

public final class a
{
  public static final boolean hsQ;
  public final Activity activity;
  public boolean hsR = false;
  public int hsS = 0;
  
  static
  {
    if (Build.VERSION.SDK_INT < 20) {}
    for (boolean bool = true;; bool = false)
    {
      hsQ = bool;
      return;
    }
  }
  
  public a(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public static boolean cK(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i > 0) {}
    for (boolean bool1 = paramContext.getBoolean(i);; bool1 = false)
    {
      try
      {
        paramContext = Class.forName("android.os.SystemProperties");
        paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
        if ("1".equals(paramContext)) {
          return false;
        }
        boolean bool2 = "0".equals(paramContext);
        if (bool2) {
          return true;
        }
      }
      catch (Exception paramContext) {}
      return bool1;
    }
  }
  
  public final void a(m paramm)
  {
    Point localPoint = new Point();
    this.activity.getWindowManager().getDefaultDisplay().getSize(localPoint);
    int j = ak.gz(this.activity);
    int k = localPoint.y;
    if ((this.activity.getWindow() != null) && ((this.activity.getWindow().getAttributes().flags & 0x400) > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = 0;
      }
      i = k - j;
      y.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[] { Integer.valueOf(i) });
      paramm.setForceHeight(i);
      return;
    }
  }
  
  public final void arF()
  {
    if ((!this.hsR) || (this.activity.isFinishing())) {}
    while (!hsQ) {
      return;
    }
    m localm = m.t(this.activity);
    if (localm == null)
    {
      y.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
      return;
    }
    a(localm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a
 * JD-Core Version:    0.7.0.1
 */