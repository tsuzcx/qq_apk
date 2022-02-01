package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class CollectHKMainUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CollectHKMainUI$1(CollectHKMainUI paramCollectHKMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(64104);
    e.o(this.pey.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
    AppMethodBeat.o(64104);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI.1
 * JD-Core Version:    0.7.0.1
 */