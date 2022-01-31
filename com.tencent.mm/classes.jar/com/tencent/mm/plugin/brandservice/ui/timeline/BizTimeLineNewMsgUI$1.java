package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineNewMsgUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineNewMsgUI$1(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(14156);
    this.jWx.finish();
    AppMethodBeat.o(14156);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.1
 * JD-Core Version:    0.7.0.1
 */