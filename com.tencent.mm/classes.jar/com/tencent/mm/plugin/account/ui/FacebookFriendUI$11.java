package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookFriendUI$11
  implements MenuItem.OnMenuItemClickListener
{
  FacebookFriendUI$11(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124818);
    this.gDg.startActivity(new Intent(this.gDg, InviteFacebookFriendsUI.class));
    AppMethodBeat.o(124818);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.11
 * JD-Core Version:    0.7.0.1
 */