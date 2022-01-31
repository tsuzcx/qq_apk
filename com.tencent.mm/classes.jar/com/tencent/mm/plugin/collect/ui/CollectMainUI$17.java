package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;

final class CollectMainUI$17
  implements o.a
{
  CollectMainUI$17(CollectMainUI paramCollectMainUI) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41271);
    paramView = new Intent();
    paramView.setClass(this.kSz.getContext(), CollectCreateQRCodeUI.class);
    paramView.putExtra("key_currency_unit", this.kSz.kRQ);
    this.kSz.startActivityForResult(paramView, 4096);
    AppMethodBeat.o(41271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.17
 * JD-Core Version:    0.7.0.1
 */