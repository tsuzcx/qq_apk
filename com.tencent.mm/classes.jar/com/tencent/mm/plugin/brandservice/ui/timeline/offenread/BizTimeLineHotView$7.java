package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class BizTimeLineHotView$7
  implements Runnable
{
  BizTimeLineHotView$7(BizTimeLineHotView paramBizTimeLineHotView) {}
  
  public final void run()
  {
    if (((BizTimeLineHotView.d(this.ihA) instanceof Activity)) && (((Activity)BizTimeLineHotView.d(this.ihA)).isFinishing())) {
      return;
    }
    if (bk.dk(BizTimeLineHotView.a(this.ihA)))
    {
      this.ihA.setVisibility(8);
      return;
    }
    if (this.ihA.getVisibility() != 0) {
      this.ihA.setVisibility(0);
    }
    BizTimeLineHotListView localBizTimeLineHotListView = BizTimeLineHotView.e(this.ihA);
    List localList = BizTimeLineHotView.a(this.ihA);
    localBizTimeLineHotListView.hfb.clear();
    localBizTimeLineHotListView.hfb.addAll(localList);
    localBizTimeLineHotListView.aE(localBizTimeLineHotListView.hfb);
    localBizTimeLineHotListView.ihr.agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.7
 * JD-Core Version:    0.7.0.1
 */