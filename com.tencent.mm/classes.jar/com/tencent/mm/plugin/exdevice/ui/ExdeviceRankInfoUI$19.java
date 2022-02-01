package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class ExdeviceRankInfoUI$19
  implements u.g
{
  ExdeviceRankInfoUI$19(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(24229);
    if (Log.getLogLevel() == 0) {}
    for (int i = 2;; i = i.aRC().getInt("WeRunLaunchGroupRankWeAppSwitch", 0))
    {
      if (i == 2) {
        params.a(3, this.yCI.getString(R.l.gGz), R.k.bottomsheet_icon_transmit);
      }
      params.a(0, this.yCI.getString(R.l.gGy), R.k.bottomsheet_icon_transmit);
      params.a(1, this.yCI.getString(R.l.gGA), R.k.bottomsheet_icon_moment);
      params.a(2, this.yCI.getString(R.l.gGx), R.k.bottomsheet_icon_donate);
      AppMethodBeat.o(24229);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.19
 * JD-Core Version:    0.7.0.1
 */