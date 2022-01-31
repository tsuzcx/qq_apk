package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceRankInfoUI$4
  implements MMPullDownView.d
{
  ExdeviceRankInfoUI$4(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean bil()
  {
    AppMethodBeat.i(20137);
    int i = ExdeviceRankInfoUI.q(this.lPt).getFirstVisiblePosition();
    if (i == 0)
    {
      View localView = ExdeviceRankInfoUI.q(this.lPt).getChildAt(i);
      if ((localView != null) && (localView.getTop() >= 0))
      {
        AppMethodBeat.o(20137);
        return true;
      }
    }
    AppMethodBeat.o(20137);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.4
 * JD-Core Version:    0.7.0.1
 */