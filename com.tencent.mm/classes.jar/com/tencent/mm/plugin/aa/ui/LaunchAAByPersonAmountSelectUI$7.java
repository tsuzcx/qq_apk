package com.tencent.mm.plugin.aa.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LaunchAAByPersonAmountSelectUI$7
  implements AbsListView.OnScrollListener
{
  LaunchAAByPersonAmountSelectUI$7(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(40796);
    if (paramInt == 1) {
      this.gqx.hideTenpayKB();
    }
    AppMethodBeat.o(40796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.7
 * JD-Core Version:    0.7.0.1
 */