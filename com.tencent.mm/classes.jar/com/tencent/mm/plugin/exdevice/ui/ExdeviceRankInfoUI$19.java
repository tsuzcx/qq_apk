package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class ExdeviceRankInfoUI$19
  implements q.f
{
  ExdeviceRankInfoUI$19(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(24229);
    if (Log.getLogLevel() == 0) {}
    for (int i = 2;; i = h.axc().getInt("WeRunLaunchGroupRankWeAppSwitch", 0))
    {
      if (i == 2) {
        paramo.b(3, this.vqr.getString(R.l.eDL), R.k.bottomsheet_icon_transmit);
      }
      paramo.b(0, this.vqr.getString(R.l.eDK), R.k.bottomsheet_icon_transmit);
      paramo.b(1, this.vqr.getString(R.l.eDM), R.k.bottomsheet_icon_moment);
      paramo.b(2, this.vqr.getString(R.l.eDJ), R.k.bottomsheet_icon_donate);
      AppMethodBeat.o(24229);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.19
 * JD-Core Version:    0.7.0.1
 */