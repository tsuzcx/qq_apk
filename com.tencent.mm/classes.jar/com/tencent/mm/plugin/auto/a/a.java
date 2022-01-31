package com.tencent.mm.plugin.auto.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  c jyq;
  
  public a()
  {
    AppMethodBeat.i(17104);
    this.jyq = new a.1(this);
    AppMethodBeat.o(17104);
  }
  
  static boolean aSC()
  {
    AppMethodBeat.i(17105);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
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
    ab.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(17105);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.a
 * JD-Core Version:    0.7.0.1
 */