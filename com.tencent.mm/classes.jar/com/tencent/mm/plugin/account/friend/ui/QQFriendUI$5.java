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
    AppMethodBeat.i(131278);
    this.mYS.hideVKB();
    this.mYS.finish();
    AppMethodBeat.o(131278);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI.5
 * JD-Core Version:    0.7.0.1
 */