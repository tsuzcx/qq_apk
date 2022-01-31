package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;

final class BizTimeLineUI$11
  implements AbsListView.OnScrollListener
{
  BizTimeLineUI$11(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    BizTimeLineUI.a(this.ihl, paramInt1, paramInt2);
    BizTimeLineUI.eo(paramInt1);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    o.ON().bR(paramInt);
    if (paramInt == 2)
    {
      ((com.tencent.mm.plugin.brandservice.a.a)g.r(com.tencent.mm.plugin.brandservice.a.a.class)).es(false);
      return;
    }
    ((com.tencent.mm.plugin.brandservice.a.a)g.r(com.tencent.mm.plugin.brandservice.a.a.class)).es(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.11
 * JD-Core Version:    0.7.0.1
 */