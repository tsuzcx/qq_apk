package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.n.d;

final class BizTimeLineNewMsgUI$7
  implements n.d
{
  BizTimeLineNewMsgUI$7(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(14162);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(14162);
      return;
      if (BizTimeLineNewMsgUI.j(this.jWx) != null) {
        z.afp().og(BizTimeLineNewMsgUI.j(this.jWx).field_msgId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.7
 * JD-Core Version:    0.7.0.1
 */