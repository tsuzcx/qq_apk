package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceRankInfoUI$2
  implements MMPullDownView.c
{
  ExdeviceRankInfoUI$2(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean bim()
  {
    AppMethodBeat.i(20135);
    View localView = ExdeviceRankInfoUI.q(this.lPt).getChildAt(ExdeviceRankInfoUI.q(this.lPt).getChildCount() - 1);
    int i = ExdeviceRankInfoUI.q(this.lPt).getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceRankInfoUI.q(this.lPt).getHeight()) && (ExdeviceRankInfoUI.q(this.lPt).getLastVisiblePosition() == i - 1))
    {
      AppMethodBeat.o(20135);
      return true;
    }
    AppMethodBeat.o(20135);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.2
 * JD-Core Version:    0.7.0.1
 */