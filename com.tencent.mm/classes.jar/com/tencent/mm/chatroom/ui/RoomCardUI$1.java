package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.MMEditText;

final class RoomCardUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RoomCardUI$1(RoomCardUI paramRoomCardUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getTitle().equals(this.dpS.getString(a.i.app_finish))) {
      RoomCardUI.a(this.dpS);
    }
    RoomCardUI.b(this.dpS).setEnabled(true);
    RoomCardUI.b(this.dpS).setFocusableInTouchMode(true);
    RoomCardUI.b(this.dpS).setFocusable(true);
    RoomCardUI.b(this.dpS).setCursorVisible(true);
    this.dpS.updateOptionMenuText(0, this.dpS.getString(a.i.app_finish));
    this.dpS.enableOptionMenu(false);
    this.dpS.showVKB();
    RoomCardUI.b(this.dpS).setSelection(RoomCardUI.b(this.dpS).getText().toString().length());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.1
 * JD-Core Version:    0.7.0.1
 */