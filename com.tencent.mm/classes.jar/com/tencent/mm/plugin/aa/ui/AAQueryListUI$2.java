package com.tencent.mm.plugin.aa.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAQueryListUI$2
  implements AbsListView.OnScrollListener
{
  AAQueryListUI$2(AAQueryListUI paramAAQueryListUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(40729);
    if ((AAQueryListUI.a(this.gpD).getLastVisiblePosition() == AAQueryListUI.a(this.gpD).getCount() - 1) && (AAQueryListUI.a(this.gpD).getCount() > 0) && (!AAQueryListUI.b(this.gpD)) && (!AAQueryListUI.c(this.gpD)))
    {
      AAQueryListUI.a(this.gpD).addFooterView(AAQueryListUI.d(this.gpD));
      AAQueryListUI.a(this.gpD, false, AAQueryListUI.e(this.gpD));
    }
    AppMethodBeat.o(40729);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.2
 * JD-Core Version:    0.7.0.1
 */