package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class ExdeviceRankInfoUI$21
  implements o.f
{
  ExdeviceRankInfoUI$21(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(179645);
    if (Log.getLogLevel() == 0) {}
    for (int i = 2;; i = h.aqJ().getInt("WeRunLaunchGroupRankWeAppSwitch", 0))
    {
      if (i == 2) {
        paramm.b(3, this.rKI.getString(2131758868), 2131689844);
      }
      paramm.b(0, this.rKI.getString(2131758866), 2131689844);
      paramm.b(1, this.rKI.getString(2131758869), 2131689830);
      paramm.b(2, this.rKI.getString(2131758865), 2131689817);
      AppMethodBeat.o(179645);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.21
 * JD-Core Version:    0.7.0.1
 */