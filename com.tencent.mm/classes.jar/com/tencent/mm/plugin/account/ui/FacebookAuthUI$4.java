package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class FacebookAuthUI$4
  implements MenuItem.OnMenuItemClickListener
{
  FacebookAuthUI$4(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.flI.getIntent();
    paramMenuItem.putExtra("bind_facebook_succ", FacebookAuthUI.b(this.flI));
    this.flI.setResult(-1, paramMenuItem);
    this.flI.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.4
 * JD-Core Version:    0.7.0.1
 */