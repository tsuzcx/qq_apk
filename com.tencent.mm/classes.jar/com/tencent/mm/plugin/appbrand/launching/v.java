package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

public class v
  implements MMActivity.a
{
  public final int bQU = v.class.hashCode() & 0xFFFF;
  
  public void alL() {}
  
  public final void alM()
  {
    if (d.gF(17)) {
      onReady();
    }
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.bQU != paramInt1) {
      return;
    }
    if (paramInt2 == -1)
    {
      y.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download ok");
      g.mo(0);
      onReady();
      return;
    }
    if (paramInt2 == 2)
    {
      y.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs cancel loading, download in background");
      alL();
      return;
    }
    y.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(Build.VERSION.SDK_INT) });
    h.nFQ.a(366L, 8L, 1L, false);
    alM();
  }
  
  public void onReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.v
 * JD-Core Version:    0.7.0.1
 */