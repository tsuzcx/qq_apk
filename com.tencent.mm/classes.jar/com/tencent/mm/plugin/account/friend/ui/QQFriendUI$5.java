package com.tencent.mm.plugin.account.friend.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QQFriendUI$5
  implements MenuItem.OnMenuItemClickListener
{
  QQFriendUI$5(QQFriendUI paramQQFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(108617);
    this.gzZ.hideVKB();
    this.gzZ.finish();
    AppMethodBeat.o(108617);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI.5
 * JD-Core Version:    0.7.0.1
 */