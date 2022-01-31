package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InviteFacebookFriendsUI$8
  implements MenuItem.OnMenuItemClickListener
{
  InviteFacebookFriendsUI$8(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124879);
    this.gDx.hideVKB();
    this.gDx.finish();
    AppMethodBeat.o(124879);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.8
 * JD-Core Version:    0.7.0.1
 */