package com.tencent.mm.plugin.appbrand.menu;

import com.huawei.easygo.sdk.EasyGo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
  extends a<ah>
{
  private static Boolean tke = null;
  private EasyGo hgI;
  
  public v()
  {
    super(x.tkj.ordinal());
    AppMethodBeat.i(323857);
    this.hgI = null;
    AppMethodBeat.o(323857);
  }
  
  private static boolean cBT()
  {
    AppMethodBeat.i(323864);
    if (tke == null) {}
    try
    {
      if (Util.getInt(d.dNI().a("clicfg_fold_appbrand_split_screen", "1", false, true), 1) > 0) {
        Log.i("MicroMsg.MenuDelegate_splitScreen", "isOpenSplitScreen!!");
      }
      for (tke = Boolean.TRUE;; tke = Boolean.FALSE)
      {
        boolean bool = tke.booleanValue();
        AppMethodBeat.o(323864);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MenuDelegate_splitScreen", localException, "isOpenSplitScreen", new Object[0]);
        tke = Boolean.FALSE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.v
 * JD-Core Version:    0.7.0.1
 */