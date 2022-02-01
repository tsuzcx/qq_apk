package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineUI$4
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$4(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(192971);
    this.mYt.finish();
    AppMethodBeat.o(192971);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.4
 * JD-Core Version:    0.7.0.1
 */