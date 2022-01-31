package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.ui.base.n.d;

final class CollectMainUI$20$4
  implements n.d
{
  CollectMainUI$20$4(CollectMainUI.20 param20) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(41277);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41277);
      return;
      if (CollectMainUI.d(this.kSJ.kSz) != null)
      {
        CollectMainUI.dE(CollectMainUI.d(this.kSJ.kSz).username, CollectMainUI.d(this.kSJ.kSz).iFJ);
        h.qsU.e(15387, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(41277);
        return;
        CollectMainUI.e(this.kSJ.kSz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.20.4
 * JD-Core Version:    0.7.0.1
 */