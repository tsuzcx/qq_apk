package com.tencent.mm.plugin.exdevice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceRankInfoUI$5
  implements AbsListView.OnScrollListener
{
  ExdeviceRankInfoUI$5(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(24211);
    ExdeviceRankInfoUI.r(this.yCI);
    AppMethodBeat.o(24211);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(24210);
    ExdeviceRankInfoUI.r(this.yCI);
    AppMethodBeat.o(24210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.5
 * JD-Core Version:    0.7.0.1
 */