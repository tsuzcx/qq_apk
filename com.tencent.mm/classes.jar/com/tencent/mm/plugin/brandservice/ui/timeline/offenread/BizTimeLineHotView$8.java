package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.widget.ImageView;

final class BizTimeLineHotView$8
  implements Runnable
{
  BizTimeLineHotView$8(BizTimeLineHotView paramBizTimeLineHotView, b paramb) {}
  
  public final void run()
  {
    Object localObject = BizTimeLineHotView.e(this.ihA);
    b localb = this.ihF;
    if (localb != null)
    {
      localObject = (BizTimeLineHotListView.b)((BizTimeLineHotListView)localObject).bK(localb.position);
      if (localObject != null)
      {
        if (!localb.ihG) {
          break label49;
        }
        ((BizTimeLineHotListView.b)localObject).ihv.setVisibility(0);
      }
    }
    return;
    label49:
    ((BizTimeLineHotListView.b)localObject).ihv.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.8
 * JD-Core Version:    0.7.0.1
 */