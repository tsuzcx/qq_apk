package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity.a;

public class ba
  implements MMActivity.a
{
  public final int requestCode;
  
  protected ba()
  {
    AppMethodBeat.i(47308);
    this.requestCode = (ba.class.hashCode() & 0xFFFF);
    AppMethodBeat.o(47308);
  }
  
  public void bnI() {}
  
  public final void bnJ()
  {
    AppMethodBeat.i(47309);
    if (d.kZ(17)) {
      onReady();
    }
    AppMethodBeat.o(47309);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47310);
    if (this.requestCode != paramInt1)
    {
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == -1)
    {
      ac.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
      f.uP(0);
      onReady();
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == 2)
    {
      ac.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
      bnI();
      AppMethodBeat.o(47310);
      return;
    }
    ac.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    h.wUl.idkeyStat(366L, 8L, 1L, false);
    bnJ();
    AppMethodBeat.o(47310);
  }
  
  public void onReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */