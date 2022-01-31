package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;

final class c
  extends a
{
  protected final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    int j = 0;
    Intent localIntent = new Intent(paramContext, AppBrandLaunchProxyUI.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("extra_from_mm", false);
    localIntent.putExtra("extra_launch_parcel", paramLaunchParcel);
    localIntent.putExtra("extra_launch_source_context", paramContext.getClass().getName());
    int i;
    if (!(paramContext instanceof AppBrandUI)) {
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        localIntent.putExtra("extra_result_receiver", new ClientLaunchEntry.1(this, new Handler(Looper.getMainLooper()), paramContext));
      }
      paramContext.startActivity(localIntent);
      return true;
      i = j;
      if (!(paramContext instanceof AppBrandPluginUI))
      {
        i = j;
        if (!(paramContext instanceof AppBrandInToolsUI)) {
          if (paramLaunchParcel.fPr != null)
          {
            i = j;
            if (paramLaunchParcel.fPr.fPF == 1) {}
          }
          else
          {
            i = j;
            if (paramLaunchParcel.gMm.scene != 1085) {
              i = 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.c
 * JD-Core Version:    0.7.0.1
 */