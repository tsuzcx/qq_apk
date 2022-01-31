package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;

final class BizTimeLineUI$14
  implements Runnable
{
  BizTimeLineUI$14(BizTimeLineUI paramBizTimeLineUI, q paramq) {}
  
  public final void run()
  {
    BizTimeLineUI.d(this.ihl).ieZ = false;
    BizTimeLineUI.f(this.ihl);
    int i = Math.max(0, BizTimeLineUI.g(this.ihl).getFirstVisiblePosition() - BizTimeLineUI.g(this.ihl).getHeaderViewsCount());
    BizTimeLineUI.d(this.ihl).a(this.hSM);
    BizTimeLineUI.d(this.ihl).a(BizTimeLineUI.d(this.ihl).oy(i));
    BizTimeLineUI.h(this.ihl);
    y.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.14
 * JD-Core Version:    0.7.0.1
 */