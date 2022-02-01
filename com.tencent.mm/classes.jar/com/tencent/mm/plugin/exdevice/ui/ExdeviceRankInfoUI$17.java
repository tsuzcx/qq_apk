package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceRankInfoUI$17
  implements n.c
{
  ExdeviceRankInfoUI$17(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(179641);
    if (ExdeviceRankInfoUI.w(this.pgf))
    {
      paraml.c(1, this.pgf.getString(2131758573));
      AppMethodBeat.o(179641);
      return;
    }
    paraml.c(0, this.pgf.getString(2131758579));
    AppMethodBeat.o(179641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.17
 * JD-Core Version:    0.7.0.1
 */