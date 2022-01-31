package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;

final class CollectMainUI$18
  implements o.a
{
  CollectMainUI$18(CollectMainUI paramCollectMainUI) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41272);
    this.kSz.kRX = false;
    this.kSz.bir();
    CollectMainUI.g(this.kSz).setText(CollectMainUI.f(this.kSz));
    CollectMainUI.h(this.kSz);
    AppMethodBeat.o(41272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.18
 * JD-Core Version:    0.7.0.1
 */