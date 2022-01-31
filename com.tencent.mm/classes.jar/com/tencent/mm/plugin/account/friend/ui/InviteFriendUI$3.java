package com.tencent.mm.plugin.account.friend.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InviteFriendUI$3
  implements MenuItem.OnMenuItemClickListener
{
  InviteFriendUI$3(InviteFriendUI paramInviteFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(108579);
    this.gzA.finish();
    AppMethodBeat.o(108579);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.3
 * JD-Core Version:    0.7.0.1
 */