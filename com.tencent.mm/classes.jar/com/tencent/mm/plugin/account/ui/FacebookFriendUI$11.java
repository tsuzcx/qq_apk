package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class FacebookFriendUI$11
  implements MenuItem.OnMenuItemClickListener
{
  FacebookFriendUI$11(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.flO.startActivity(new Intent(this.flO, InviteFacebookFriendsUI.class));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.11
 * JD-Core Version:    0.7.0.1
 */