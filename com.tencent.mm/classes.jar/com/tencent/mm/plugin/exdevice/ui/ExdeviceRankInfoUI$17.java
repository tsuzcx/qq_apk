package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class ExdeviceRankInfoUI$17
  implements o.f
{
  ExdeviceRankInfoUI$17(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(179641);
    if (ExdeviceRankInfoUI.w(this.rKI))
    {
      paramm.d(1, this.rKI.getString(2131758874));
      AppMethodBeat.o(179641);
      return;
    }
    paramm.d(0, this.rKI.getString(2131758880));
    AppMethodBeat.o(179641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.17
 * JD-Core Version:    0.7.0.1
 */