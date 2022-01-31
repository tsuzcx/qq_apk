package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;

final class CollectMainUI$16
  implements o.a
{
  CollectMainUI$16(CollectMainUI paramCollectMainUI) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41270);
    if (CollectMainUI.b(this.kSz) == 1)
    {
      CollectMainUI.c(this.kSz);
      com.tencent.mm.ui.base.h.a(this.kSz.getContext(), this.kSz.getString(2131298473), "", this.kSz.getString(2131298472), this.kSz.getString(2131296888), true, new CollectMainUI.16.1(this), new CollectMainUI.16.2(this));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13944, new Object[] { Integer.valueOf(5) });
      AppMethodBeat.o(41270);
      return;
      CollectMainUI.e(this.kSz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.16
 * JD-Core Version:    0.7.0.1
 */