package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class CollectHKMainUI$3
  implements View.OnClickListener
{
  CollectHKMainUI$3(CollectHKMainUI paramCollectHKMainUI, m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41245);
    if (!bo.isNullOrNil(this.kRq.kNH)) {
      e.m(this.kRs.getContext(), this.kRq.kNH, true);
    }
    AppMethodBeat.o(41245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI.3
 * JD-Core Version:    0.7.0.1
 */