package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceRankInfoUI$3
  implements MMPullDownView.c
{
  ExdeviceRankInfoUI$3(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean bPj()
  {
    AppMethodBeat.i(179631);
    View localView = ExdeviceRankInfoUI.q(this.pgf).getChildAt(ExdeviceRankInfoUI.q(this.pgf).getChildCount() - 1);
    int i = ExdeviceRankInfoUI.q(this.pgf).getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceRankInfoUI.q(this.pgf).getHeight()) && (ExdeviceRankInfoUI.q(this.pgf).getLastVisiblePosition() == i - 1))
    {
      AppMethodBeat.o(179631);
      return true;
    }
    AppMethodBeat.o(179631);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.3
 * JD-Core Version:    0.7.0.1
 */