package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.sdk.platformtools.y;

final class BizTimeLineUI$5
  implements Runnable
{
  BizTimeLineUI$5(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void run()
  {
    BizTimeLineUI.l(this.ihl);
    if (!this.ihl.isFinishing())
    {
      this.ihl.aya();
      return;
    }
    y.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.5
 * JD-Core Version:    0.7.0.1
 */