package com.tencent.mm.plugin.brandservice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class BizSearchResultItemContainer$1
  implements AbsListView.OnScrollListener
{
  boolean icY = false;
  
  BizSearchResultItemContainer$1(BizSearchResultItemContainer paramBizSearchResultItemContainer) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 == paramInt3)
    {
      this.icY = true;
      return;
    }
    this.icY = false;
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.icY) && (BizSearchResultItemContainer.a(this.icZ))) {
      BizSearchResultItemContainer.a(this.icZ, BizSearchResultItemContainer.b(this.icZ).bGm, BizSearchResultItemContainer.b(this.icZ).offset, BizSearchResultItemContainer.c(this.icZ)[(BizSearchResultItemContainer.c(this.icZ).length - 1)]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.1
 * JD-Core Version:    0.7.0.1
 */