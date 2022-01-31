package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceRankInfoUI$9
  implements Runnable
{
  ExdeviceRankInfoUI$9(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(20143);
    ExdeviceRankInfoUI.u(this.lPt);
    if (!ExdeviceRankInfoUI.v(this.lPt))
    {
      ExdeviceRankInfoUI.h(this.lPt);
      AppMethodBeat.o(20143);
      return;
    }
    ExdeviceRankInfoUI.b(this.lPt).notifyDataSetChanged();
    AppMethodBeat.o(20143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.9
 * JD-Core Version:    0.7.0.1
 */