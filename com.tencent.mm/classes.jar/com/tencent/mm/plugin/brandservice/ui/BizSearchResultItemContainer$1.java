package com.tencent.mm.plugin.brandservice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizSearchResultItemContainer$1
  implements AbsListView.OnScrollListener
{
  boolean jTN = false;
  
  BizSearchResultItemContainer$1(BizSearchResultItemContainer paramBizSearchResultItemContainer) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 == paramInt3)
    {
      this.jTN = true;
      return;
    }
    this.jTN = false;
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(13898);
    if ((paramInt == 0) && (this.jTN) && (BizSearchResultItemContainer.a(this.jTO))) {
      BizSearchResultItemContainer.a(this.jTO, BizSearchResultItemContainer.b(this.jTO).cnv, BizSearchResultItemContainer.b(this.jTO).offset, BizSearchResultItemContainer.c(this.jTO)[(BizSearchResultItemContainer.c(this.jTO).length - 1)]);
    }
    AppMethodBeat.o(13898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.1
 * JD-Core Version:    0.7.0.1
 */