package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceRankInfoUI$1
  implements Runnable
{
  ExdeviceRankInfoUI$1(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(20134);
    ExdeviceRankInfoUI.b(this.lPt).lOu = ExdeviceRankInfoUI.a(this.lPt);
    ExdeviceRankInfoUI.b(this.lPt).notifyDataSetChanged();
    ExdeviceRankInfoUI.c(this.lPt);
    AppMethodBeat.o(20134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.1
 * JD-Core Version:    0.7.0.1
 */