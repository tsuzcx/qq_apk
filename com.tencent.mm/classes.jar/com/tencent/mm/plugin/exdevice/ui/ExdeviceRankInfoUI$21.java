package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceRankInfoUI$21
  implements n.c
{
  ExdeviceRankInfoUI$21(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(179645);
    if (ad.getLogLevel() == 0) {}
    for (int i = 2;; i = g.Zd().getInt("WeRunLaunchGroupRankWeAppSwitch", 0))
    {
      if (i == 2) {
        paraml.a(3, this.pgf.getString(2131758567), 2131689831);
      }
      paraml.a(0, this.pgf.getString(2131758565), 2131689831);
      paraml.a(1, this.pgf.getString(2131758568), 2131689817);
      paraml.a(2, this.pgf.getString(2131758564), 2131689804);
      AppMethodBeat.o(179645);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.21
 * JD-Core Version:    0.7.0.1
 */