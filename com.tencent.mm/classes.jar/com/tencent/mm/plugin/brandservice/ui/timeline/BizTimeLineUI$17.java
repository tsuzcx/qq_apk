package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;

final class BizTimeLineUI$17
  implements Runnable
{
  BizTimeLineUI$17(BizTimeLineUI paramBizTimeLineUI, q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(14201);
    BizTimeLineUI.c(this.jXh).jVQ = false;
    BizTimeLineUI.i(this.jXh);
    int i = Math.max(0, BizTimeLineUI.b(this.jXh).getFirstVisiblePosition() - BizTimeLineUI.b(this.jXh).getHeaderViewsCount());
    BizTimeLineUI.c(this.jXh).b(this.jMz);
    BizTimeLineUI.c(this.jXh).b(BizTimeLineUI.c(this.jXh).se(i));
    BizTimeLineUI.j(this.jXh);
    ab.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(14201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.17
 * JD-Core Version:    0.7.0.1
 */