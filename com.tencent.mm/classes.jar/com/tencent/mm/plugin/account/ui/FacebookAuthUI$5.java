package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookAuthUI$5
  implements MenuItem.OnMenuItemClickListener
{
  FacebookAuthUI$5(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124778);
    paramMenuItem = this.gDa.getIntent();
    paramMenuItem.putExtra("bind_facebook_succ", FacebookAuthUI.b(this.gDa));
    this.gDa.setResult(-1, paramMenuItem);
    this.gDa.finish();
    AppMethodBeat.o(124778);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.5
 * JD-Core Version:    0.7.0.1
 */