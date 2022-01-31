package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;

final class AppBrandLauncherUI$3$1
  implements Runnable
{
  AppBrandLauncherUI$3$1(AppBrandLauncherUI.3 param3) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Bundle localBundle = ActivityOptions.makeSceneTransitionAnimation(this.hcY.hcX, new Pair[0]).toBundle();; localBundle = null)
    {
      this.hcY.hcX.startActivityForResult(((a)g.r(a.class)).cd(this.hcY.hcX), 1, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.3.1
 * JD-Core Version:    0.7.0.1
 */