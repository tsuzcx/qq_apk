package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;

final class AppBrandLauncherUI$3$1
  implements Runnable
{
  AppBrandLauncherUI$3$1(AppBrandLauncherUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(132972);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Bundle localBundle = ActivityOptions.makeSceneTransitionAnimation(this.iMM.iML, new Pair[0]).toBundle();; localBundle = null)
    {
      if (AppBrandLauncherUI.b(this.iMM.iML) == 13) {}
      for (int i = 52;; i = 201)
      {
        this.iMM.iML.startActivityForResult(((a)g.E(a.class)).E(this.iMM.iML, i), 1, localBundle);
        AppMethodBeat.o(132972);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.3.1
 * JD-Core Version:    0.7.0.1
 */