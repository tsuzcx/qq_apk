package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
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
  
  public void bgO() {}
  
  public final void bgP()
  {
    AppMethodBeat.i(47309);
    if (d.lf(17)) {
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
      ad.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
      f.tX(0);
      onReady();
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == 2)
    {
      ad.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
      bgO();
      AppMethodBeat.o(47310);
      return;
    }
    ad.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    h.vKh.idkeyStat(366L, 8L, 1L, false);
    bgP();
    AppMethodBeat.o(47310);
  }
  
  public void onReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */