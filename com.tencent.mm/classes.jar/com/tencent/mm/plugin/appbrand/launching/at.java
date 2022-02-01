package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.luggage.sdk.processes.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;

public class at
  implements y, MMActivity.a
{
  public final int requestCode;
  
  protected at()
  {
    AppMethodBeat.i(47308);
    this.requestCode = (at.class.hashCode() & 0xFFFF);
    AppMethodBeat.o(47308);
  }
  
  public void NR() {}
  
  public final boolean bZy()
  {
    return true;
  }
  
  public void cad() {}
  
  public void cae()
  {
    AppMethodBeat.i(47309);
    if (d.qV(17)) {
      NR();
    }
    AppMethodBeat.o(47309);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47310);
    if (this.requestCode != paramInt1)
    {
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == -1)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
      g.cjb().b(b.cBi);
      NR();
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == 2)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
      cad();
      AppMethodBeat.o(47310);
      return;
    }
    Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    h.IzE.idkeyStat(366L, 8L, 1L, false);
    cae();
    AppMethodBeat.o(47310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.at
 * JD-Core Version:    0.7.0.1
 */