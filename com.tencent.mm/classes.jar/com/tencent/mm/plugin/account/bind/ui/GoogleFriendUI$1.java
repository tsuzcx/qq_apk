package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GoogleFriendUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GoogleFriendUI$1(GoogleFriendUI paramGoogleFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13650);
    this.gvr.finish();
    AppMethodBeat.o(13650);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.1
 * JD-Core Version:    0.7.0.1
 */