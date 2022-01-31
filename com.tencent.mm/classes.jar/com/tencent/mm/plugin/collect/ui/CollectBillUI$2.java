package com.tencent.mm.plugin.collect.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

final class CollectBillUI$2
  implements AbsListView.OnScrollListener
{
  CollectBillUI$2(CollectBillUI paramCollectBillUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((CollectBillUI.b(this.iKD).getLastVisiblePosition() == CollectBillUI.c(this.iKD).getCount()) && (CollectBillUI.c(this.iKD).getCount() > 0) && (!CollectBillUI.d(this.iKD)) && (!CollectBillUI.e(this.iKD)))
    {
      CollectBillUI.f(this.iKD);
      CollectBillUI.g(this.iKD);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.2
 * JD-Core Version:    0.7.0.1
 */