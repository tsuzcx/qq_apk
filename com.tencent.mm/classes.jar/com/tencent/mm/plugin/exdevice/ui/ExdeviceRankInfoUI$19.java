package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceRankInfoUI$19
  implements n.c
{
  ExdeviceRankInfoUI$19(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(20157);
    if (ab.getLogLevel() == 0) {}
    for (int i = 2;; i = g.Nq().getInt("WeRunLaunchGroupRankWeAppSwitch", 0))
    {
      if (i == 2) {
        paraml.a(3, this.lPt.getString(2131299437), 2131231038);
      }
      paraml.a(0, this.lPt.getString(2131299435), 2131231038);
      paraml.a(1, this.lPt.getString(2131299438), 2131231024);
      paraml.a(2, this.lPt.getString(2131299434), 2131231011);
      AppMethodBeat.o(20157);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.19
 * JD-Core Version:    0.7.0.1
 */