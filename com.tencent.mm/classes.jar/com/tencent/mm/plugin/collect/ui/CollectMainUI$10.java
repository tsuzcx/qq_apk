package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class CollectMainUI$10
  implements View.OnClickListener
{
  CollectMainUI$10(CollectMainUI paramCollectMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142000);
    if (!bo.isNullOrNil(CollectMainUI.t(this.kSz))) {
      e.m(ah.getContext(), CollectMainUI.t(this.kSz), true);
    }
    AppMethodBeat.o(142000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.10
 * JD-Core Version:    0.7.0.1
 */