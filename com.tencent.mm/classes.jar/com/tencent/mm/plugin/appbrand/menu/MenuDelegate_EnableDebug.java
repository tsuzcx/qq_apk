package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.base.l;

public final class MenuDelegate_EnableDebug
  extends a
{
  public MenuDelegate_EnableDebug()
  {
    super(o.gPm.ordinal());
  }
  
  public static void e(Context paramContext, final String paramString, boolean paramBoolean)
  {
    MenuDelegate_EnableDebug.SetAppDebugModeTask localSetAppDebugModeTask = new MenuDelegate_EnableDebug.SetAppDebugModeTask((byte)0);
    localSetAppDebugModeTask.appId = paramString;
    localSetAppDebugModeTask.bIU = paramBoolean;
    AppBrandMainProcessService.a(localSetAppDebugModeTask);
    if (localSetAppDebugModeTask.bIU) {}
    for (paramString = paramContext.getString(y.j.app_brand_debug_enabled_toast);; paramString = paramContext.getString(y.j.app_brand_debug_disabled_toast))
    {
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).runOnUiThread(new Runnable()
        {
          public final void run()
          {
            Toast.makeText(this.val$context, paramString, 0).show();
            ((Activity)this.val$context).finish();
          }
        });
      }
      return;
    }
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    if (j.sm(paramString)) {
      if (!paramq.getRuntime().ZB().fPN) {
        break label42;
      }
    }
    label42:
    for (paramContext = paramContext.getString(y.j.app_brand_disable_debug);; paramContext = paramContext.getString(y.j.app_brand_enable_debug))
    {
      paraml.e(o.gPm.ordinal(), paramContext);
      return;
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    if (!paramq.getRuntime().ZB().fPN) {}
    for (boolean bool = true;; bool = false)
    {
      e(paramContext, paramString, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug
 * JD-Core Version:    0.7.0.1
 */