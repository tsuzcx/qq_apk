package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class RoomCardUI$6
  implements MenuItem.OnMenuItemClickListener
{
  RoomCardUI$6(RoomCardUI paramRoomCardUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(155171);
    if (paramMenuItem.getTitle().equals(this.ehp.getString(2131296964))) {
      RoomCardUI.a(this.ehp);
    }
    RoomCardUI.b(this.ehp).setEnabled(true);
    RoomCardUI.b(this.ehp).setFocusableInTouchMode(true);
    RoomCardUI.b(this.ehp).setFocusable(true);
    RoomCardUI.b(this.ehp).setCursorVisible(true);
    this.ehp.updateOptionMenuText(0, this.ehp.getString(2131296964));
    this.ehp.enableOptionMenu(false);
    this.ehp.showVKB();
    RoomCardUI.b(this.ehp).setSelection(RoomCardUI.b(this.ehp).getText().toString().length());
    AppMethodBeat.o(155171);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.6
 * JD-Core Version:    0.7.0.1
 */