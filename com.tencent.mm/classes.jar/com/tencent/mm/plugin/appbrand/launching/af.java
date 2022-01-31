package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

public class af
  implements MMActivity.a
{
  public final int requestCode;
  
  protected af()
  {
    AppMethodBeat.i(131946);
    this.requestCode = (af.class.hashCode() & 0xFFFF);
    AppMethodBeat.o(131946);
  }
  
  public void aHe() {}
  
  public final void aHf()
  {
    AppMethodBeat.i(131947);
    if (d.fv(17)) {
      onReady();
    }
    AppMethodBeat.o(131947);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131948);
    if (this.requestCode != paramInt1)
    {
      AppMethodBeat.o(131948);
      return;
    }
    if (paramInt2 == -1)
    {
      ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
      com.tencent.mm.plugin.appbrand.task.h.pA(0);
      onReady();
      AppMethodBeat.o(131948);
      return;
    }
    if (paramInt2 == 2)
    {
      ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
      aHe();
      AppMethodBeat.o(131948);
      return;
    }
    ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(366L, 8L, 1L, false);
    aHf();
    AppMethodBeat.o(131948);
  }
  
  public void onReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.af
 * JD-Core Version:    0.7.0.1
 */