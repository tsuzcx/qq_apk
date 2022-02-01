package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceRankInfoUI$4
  implements MMPullDownView.d
{
  ExdeviceRankInfoUI$4(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean dsp()
  {
    AppMethodBeat.i(24209);
    int i = ExdeviceRankInfoUI.q(this.yCI).getFirstVisiblePosition();
    if (i == 0)
    {
      View localView = ExdeviceRankInfoUI.q(this.yCI).getChildAt(i);
      if ((localView != null) && (localView.getTop() >= 0))
      {
        AppMethodBeat.o(24209);
        return true;
      }
    }
    AppMethodBeat.o(24209);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.4
 * JD-Core Version:    0.7.0.1
 */