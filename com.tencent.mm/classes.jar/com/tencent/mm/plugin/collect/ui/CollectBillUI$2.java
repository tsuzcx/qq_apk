package com.tencent.mm.plugin.collect.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CollectBillUI$2
  implements AbsListView.OnScrollListener
{
  CollectBillUI$2(CollectBillUI paramCollectBillUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(41212);
    if ((CollectBillUI.b(this.kRi).getLastVisiblePosition() == CollectBillUI.c(this.kRi).getCount()) && (CollectBillUI.c(this.kRi).getCount() > 0) && (!CollectBillUI.d(this.kRi)) && (!CollectBillUI.e(this.kRi)))
    {
      CollectBillUI.f(this.kRi);
      CollectBillUI.g(this.kRi);
    }
    AppMethodBeat.o(41212);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.2
 * JD-Core Version:    0.7.0.1
 */