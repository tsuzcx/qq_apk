package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.y;

final class BizTimeLineUI$10
  implements Runnable
{
  BizTimeLineUI$10(BizTimeLineUI paramBizTimeLineUI, ProgressDialog paramProgressDialog) {}
  
  public final void run()
  {
    if ((this.doh != null) && (this.doh.isShowing())) {
      this.doh.dismiss();
    }
    if (this.ihl.isFinishing())
    {
      y.w("MicroMsg.BizTimeLineUI", "checkInitListView isFinishing, just return");
      return;
    }
    BizTimeLineUI.a(this.ihl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.10
 * JD-Core Version:    0.7.0.1
 */