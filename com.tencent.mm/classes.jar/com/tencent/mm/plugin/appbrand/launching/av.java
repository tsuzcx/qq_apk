package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;

public class av
  implements aa, MMActivity.a
{
  public final int requestCode;
  
  protected av()
  {
    AppMethodBeat.i(47308);
    this.requestCode = (av.class.hashCode() & 0xFFFF);
    AppMethodBeat.o(47308);
  }
  
  public void bNL() {}
  
  public void bNM()
  {
    AppMethodBeat.i(47309);
    if (d.oD(17)) {
      onReady();
    }
    AppMethodBeat.o(47309);
  }
  
  public final boolean bNh()
  {
    return true;
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
      com.tencent.mm.plugin.appbrand.task.h.bWb().zn(0);
      onReady();
      AppMethodBeat.o(47310);
      return;
    }
    if (paramInt2 == 2)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
      bNL();
      AppMethodBeat.o(47310);
      return;
    }
    Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(366L, 8L, 1L, false);
    bNM();
    AppMethodBeat.o(47310);
  }
  
  public void onReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av
 * JD-Core Version:    0.7.0.1
 */