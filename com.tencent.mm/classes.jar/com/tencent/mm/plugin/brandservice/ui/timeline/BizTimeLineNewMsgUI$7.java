package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import com.tencent.mm.ai.z;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.n.d;

final class BizTimeLineNewMsgUI$7
  implements n.d
{
  BizTimeLineNewMsgUI$7(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      return;
    } while (BizTimeLineNewMsgUI.j(this.igE) == null);
    z.MF().hz(BizTimeLineNewMsgUI.j(this.igE).field_msgId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.7
 * JD-Core Version:    0.7.0.1
 */