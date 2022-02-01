package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceRankInfoUI$2
  implements MMPullDownView.c
{
  ExdeviceRankInfoUI$2(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final boolean dsq()
  {
    AppMethodBeat.i(24207);
    View localView = ExdeviceRankInfoUI.q(this.yCI).getChildAt(ExdeviceRankInfoUI.q(this.yCI).getChildCount() - 1);
    int i = ExdeviceRankInfoUI.q(this.yCI).getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceRankInfoUI.q(this.yCI).getHeight()) && (ExdeviceRankInfoUI.q(this.yCI).getLastVisiblePosition() == i - 1))
    {
      AppMethodBeat.o(24207);
      return true;
    }
    AppMethodBeat.o(24207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.2
 * JD-Core Version:    0.7.0.1
 */