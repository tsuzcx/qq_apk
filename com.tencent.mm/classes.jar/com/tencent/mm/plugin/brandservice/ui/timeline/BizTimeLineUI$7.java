package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.bizui.widget.StoryListView;

final class BizTimeLineUI$7
  implements Runnable
{
  BizTimeLineUI$7(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    BizTimeLineUI.n(this.ihl);
    if ((!this.ihl.isFinishing()) && (BizTimeLineUI.g(this.ihl) != null)) {
      BizTimeLineUI.b(this.ihl, BizTimeLineUI.g(this.ihl).getFirstVisiblePosition(), BizTimeLineUI.g(this.ihl).getLastVisiblePosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.7
 * JD-Core Version:    0.7.0.1
 */