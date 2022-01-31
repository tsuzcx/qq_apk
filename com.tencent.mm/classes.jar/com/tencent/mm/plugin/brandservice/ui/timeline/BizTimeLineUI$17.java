package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;

final class BizTimeLineUI$17
  implements Runnable
{
  BizTimeLineUI$17(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    if ((this.ihl.isFinishing()) || (BizTimeLineUI.g(this.ihl) == null) || (BizTimeLineUI.g(this.ihl).getFirstVisiblePosition() != 0) || (BizTimeLineUI.p(this.ihl) == null)) {
      return;
    }
    BizTimeLineUI.p(this.ihl).aye();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.17
 * JD-Core Version:    0.7.0.1
 */