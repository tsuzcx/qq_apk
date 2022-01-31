package com.tencent.mm.plugin.aa.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

final class AAQueryListUI$2
  implements AbsListView.OnScrollListener
{
  AAQueryListUI$2(AAQueryListUI paramAAQueryListUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((AAQueryListUI.a(this.eXG).getLastVisiblePosition() == AAQueryListUI.a(this.eXG).getCount() - 1) && (AAQueryListUI.a(this.eXG).getCount() > 0) && (!AAQueryListUI.b(this.eXG)) && (!AAQueryListUI.c(this.eXG)))
    {
      AAQueryListUI.a(this.eXG).addFooterView(AAQueryListUI.d(this.eXG));
      AAQueryListUI.a(this.eXG, false, AAQueryListUI.e(this.eXG));
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.2
 * JD-Core Version:    0.7.0.1
 */