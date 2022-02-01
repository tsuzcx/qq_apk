package com.tencent.mm.plugin.appbrand.menu;

import com.huawei.easygo.sdk.EasyGo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  extends a<ah>
{
  private static Boolean qfz = null;
  private EasyGo easyGoManager;
  
  public u()
  {
    super(w.qfF.ordinal());
    AppMethodBeat.i(269624);
    this.easyGoManager = null;
    AppMethodBeat.o(269624);
  }
  
  private static boolean cbz()
  {
    AppMethodBeat.i(269627);
    if (qfz == null) {}
    try
    {
      if (Util.getInt(d.dgX().a("clicfg_fold_appbrand_split_screen", "1", false, true), 1) > 0) {
        Log.i("MicroMsg.MenuDelegate_splitScreen", "isOpenSplitScreen!!");
      }
      for (qfz = Boolean.TRUE;; qfz = Boolean.FALSE)
      {
        boolean bool = qfz.booleanValue();
        AppMethodBeat.o(269627);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MenuDelegate_splitScreen", localException, "isOpenSplitScreen", new Object[0]);
        qfz = Boolean.FALSE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.u
 * JD-Core Version:    0.7.0.1
 */