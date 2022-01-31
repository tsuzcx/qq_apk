package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.widget.StoryListView;

final class BizTimeLineUI$8
  implements Runnable
{
  BizTimeLineUI$8(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(14190);
    BizTimeLineUI.p(this.jXh);
    if ((!this.jXh.isFinishing()) && (BizTimeLineUI.b(this.jXh) != null)) {
      BizTimeLineUI.b(this.jXh, BizTimeLineUI.b(this.jXh).getFirstVisiblePosition(), BizTimeLineUI.b(this.jXh).getLastVisiblePosition());
    }
    AppMethodBeat.o(14190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.8
 * JD-Core Version:    0.7.0.1
 */