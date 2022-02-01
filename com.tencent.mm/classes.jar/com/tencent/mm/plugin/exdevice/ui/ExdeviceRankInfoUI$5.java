package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceRankInfoUI$5
  implements MMPullDownView.d
{
  ExdeviceRankInfoUI$5(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean bPi()
  {
    AppMethodBeat.i(179633);
    int i = ExdeviceRankInfoUI.q(this.pgf).getFirstVisiblePosition();
    if (i == 0)
    {
      View localView = ExdeviceRankInfoUI.q(this.pgf).getChildAt(i);
      if ((localView != null) && (localView.getTop() >= 0))
      {
        AppMethodBeat.o(179633);
        return true;
      }
    }
    AppMethodBeat.o(179633);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.5
 * JD-Core Version:    0.7.0.1
 */