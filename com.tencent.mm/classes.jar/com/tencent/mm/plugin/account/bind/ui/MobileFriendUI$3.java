package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileFriendUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MobileFriendUI$3(MobileFriendUI paramMobileFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110147);
    this.mUK.hideVKB();
    this.mUK.finish();
    AppMethodBeat.o(110147);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.3
 * JD-Core Version:    0.7.0.1
 */