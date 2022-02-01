package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookFriendUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FacebookFriendUI$2(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127959);
    this.jjP.hideVKB();
    this.jjP.finish();
    AppMethodBeat.o(127959);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.2
 * JD-Core Version:    0.7.0.1
 */