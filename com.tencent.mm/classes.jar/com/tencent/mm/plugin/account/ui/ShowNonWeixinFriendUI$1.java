package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShowNonWeixinFriendUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShowNonWeixinFriendUI$1(ShowNonWeixinFriendUI paramShowNonWeixinFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125584);
    this.gKq.hideVKB();
    this.gKq.finish();
    AppMethodBeat.o(125584);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.1
 * JD-Core Version:    0.7.0.1
 */