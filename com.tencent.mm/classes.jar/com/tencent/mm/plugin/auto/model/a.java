package com.tencent.mm.plugin.auto.model;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  IListener uVH;
  
  public a()
  {
    AppMethodBeat.i(21156);
    this.uVH = new AutoLogic.1(this, f.hfK);
    AppMethodBeat.o(21156);
  }
  
  public static boolean cUA()
  {
    AppMethodBeat.i(21157);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.projection.gearhead", 1);
      bool = true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    Log.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(21157);
    return bool;
  }
  
  public static boolean cUy()
  {
    AppMethodBeat.i(260338);
    if (((c)h.ax(c.class)).a(c.a.zhi, 1) == 1)
    {
      AppMethodBeat.o(260338);
      return true;
    }
    AppMethodBeat.o(260338);
    return false;
  }
  
  public static boolean cUz()
  {
    AppMethodBeat.i(260340);
    if (((UiModeManager)MMApplicationContext.getContext().getSystemService("uimode")).getCurrentModeType() == 3)
    {
      AppMethodBeat.o(260340);
      return true;
    }
    AppMethodBeat.o(260340);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.model.a
 * JD-Core Version:    0.7.0.1
 */