package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;

final class BizTimeLineUI$10
  implements Runnable
{
  BizTimeLineUI$10(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(14193);
    if ((this.jXh.isFinishing()) || (BizTimeLineUI.b(this.jXh) == null) || (BizTimeLineUI.b(this.jXh).getFirstVisiblePosition() != 0) || (BizTimeLineUI.r(this.jXh) == null))
    {
      AppMethodBeat.o(14193);
      return;
    }
    BizTimeLineUI.r(this.jXh).aWZ();
    AppMethodBeat.o(14193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.10
 * JD-Core Version:    0.7.0.1
 */